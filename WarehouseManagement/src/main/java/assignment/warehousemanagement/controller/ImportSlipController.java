package assignment.warehousemanagement.controller;

import assignment.warehousemanagement.Ulti.Counter;
import assignment.warehousemanagement.entity.*;
import assignment.warehousemanagement.entity.ProductInSlip;
import assignment.warehousemanagement.service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@AllArgsConstructor
@RequestMapping("/import-slip")
public class ImportSlipController {
    private final ImportSlipService importSlipService;
    private final SupplierService supplierService;
    private final ProductService productService;
    private final ProductInSlipService productInSlipService;
    private final SlipService slipService;
    private final EmployeeService employeeService;
    private Map<Product, Integer> orders;
    private List<String> messages;

    @Autowired
    public ImportSlipController(ImportSlipService importSlipService,
                                SupplierService supplierService,
                                ProductService productService,
                                ProductInSlipService productInSlipService,
                                SlipService slipService,
                                EmployeeService employeeService){
        this.importSlipService = importSlipService;
        this.supplierService = supplierService;
        this.productService = productService;
        this.productInSlipService = productInSlipService;
        this.slipService = slipService;
        this.employeeService = employeeService;
        orders = new HashMap<>();
        messages = Arrays.asList("", "", "");
    }
    @GetMapping("/new")
    public String showCreateNewImportSlipForm(Model model) {
        if (!orders.isEmpty()){
            messages.set(2, "");
        }
        model.addAttribute("suppList", supplierService.getAllSuppliers());
        model.addAttribute("prdList", productService.getAllProducts());
        model.addAttribute("orders", orders);
        model.addAttribute("messages", messages);
        model.addAttribute("counter", new Counter());
        return "importSlipMenu/newImportSlip";
    }

    @GetMapping("/new/new-row")
    public String createASlipRow(@RequestParam("prdInfo") String prdId,
                                 @RequestParam("quantity") String quantityStr) {
        try {
            prdId = prdId.substring(prdId.indexOf('(') + 1, prdId.lastIndexOf(')'));
            int quantity = Integer.parseInt(quantityStr);
            Product prd = productService.getProductById(Integer.parseInt(prdId));
            if (orders.containsKey(prd)) {
                orders.put(prd, orders.get(prd) + quantity);
            } else {
                orders.put(prd, quantity);
            }
            messages.set(1, "");
        } catch (StringIndexOutOfBoundsException ex) {
            messages.set(1, "Hãy chọn sản phẩm!");
        } catch (NumberFormatException ex) {
            messages.set(1, "Số lượng sản phẩm phải là số nguyên!");
        }
        return "redirect:/import-slip/new";
    }

    @GetMapping("/new/delete-row/{id}")
    public String deleteASlipRow(@PathVariable String id) {
        for (Product prd : orders.keySet()) {
            if (prd.getId().toString().equalsIgnoreCase(id)) {
                orders.remove(prd);
                break;
            }
        }
        return "redirect:/import-slip/new";
    }

    private Integer getSupplierIdFromContext(String context) {
        try {
            context = context.substring(context.indexOf('(') + 1, context.lastIndexOf(')'));
        } catch (StringIndexOutOfBoundsException ex) {
            return -1;
        }
        return Integer.parseInt(context);
    }
    private Integer createSlip(Integer id){
        ImportSlip importSlip = new ImportSlip();
        importSlip.setSupplier(supplierService.getSupplierById(id));
        importSlip.setEmployeeCreate(employeeService.getEmployeeById(1));
        float amountSum = 0;
        Set<ProductInSlip> allPis = new HashSet<>();
        for (Product prd : orders.keySet()) {
            amountSum += prd.getPrice() * orders.get(prd);
            ProductInSlip pis = new ProductInSlip(prd, orders.get(prd));
            pis.setSlip(importSlip);
            allPis.add(pis);
        }
        importSlip.setTotalCost(amountSum);
        slipService.saveSlip(importSlip);
        id = importSlipService.saveImportSlip(importSlip).getId();
        productInSlipService.saveAllProductInSlips(allPis);
        return id;
    }
    @PostMapping("/new/success")
    public String createNewImportSlip(@RequestParam("suppInfo") String suppInfo) {
        boolean valid = true;
        Integer id = getSupplierIdFromContext(suppInfo);
        if(id == -1){
            messages.set(0, "Hãy chọn nhà cung cấp!");
            valid = false;
        }
        else {
            messages.set(0, "");
        }
        if(orders.isEmpty()){
            messages.set(2, "Phiếu chưa có sản phẩm!");
            valid = false;
        }
        else {
            messages.set(2, "");
        }
        if (!valid){
            return "redirect:/import-slip/new";
        }
        id = createSlip(id);
        return "redirect:/import-slip/new/success/" + id.toString();
    }

    @GetMapping("/new/success/{id}")
    public String showSuccessForm(@PathVariable("id") String id,
                                  Model model) {
        ImportSlip slip = importSlipService.getImportSlipById(Integer.parseInt(id));
        int quantitySum = 0;
        float unitPriceSum = 0;
        Map<Product, Integer> orders_copy = new HashMap<>();
        for (Product prd : orders.keySet()) {
            int quantity = orders.get(prd);
            quantitySum += quantity;
            unitPriceSum += prd.getPrice();
            prd.setQuantity(prd.getQuantity() + quantity);
            Product product = prd;
            orders.remove(prd);
            orders_copy.put(product, quantity);
            productService.saveProduct(product);
        }
        model.addAttribute("counter", new Counter());
        model.addAttribute("slipId", id);
        model.addAttribute("createTime", slip.getCreatedTime());
        model.addAttribute("employee", "tqh");
        model.addAttribute("supplier", slip.getSupplier().getName());
        model.addAttribute("orders", orders_copy);
        model.addAttribute("quantitySum", quantitySum);
        model.addAttribute("unitPriceSum", unitPriceSum);
        model.addAttribute("amountSum", slip.getTotalCost());
        return "importSlipMenu/createSlipSuccessForm";
    }
}
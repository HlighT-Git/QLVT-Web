package assignment.warehousemanagement.entity;

import assignment.warehousemanagement.entity.Product;
import assignment.warehousemanagement.entity.Slip;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class ProductInSlip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "slip_id")
    private Slip slip;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantity = 1;
    public float getAmount(){
        return product.getPrice() * quantity;
    }
    public ProductInSlip(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }
}

package assignment.warehousemanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class ImportSlip extends Slip {
    @ManyToOne(targetEntity = Supplier.class)
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;
}

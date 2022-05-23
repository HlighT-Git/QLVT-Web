package assignment.warehousemanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
public abstract class Slip {
    private static final int serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date createdTime;
    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_create_id", referencedColumnName = "id")
    private Employee employeeCreate;
    @PrePersist
    void createdTime() {
        this.createdTime = new Date();
    }
    private float totalCost;
}

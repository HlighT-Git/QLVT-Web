package assignment.warehousemanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class ExportSlip extends Slip {
    @ManyToOne(targetEntity = Agent.class)
    @JoinColumn(name = "agent_id", referencedColumnName = "id")
    private Agent agent;
}

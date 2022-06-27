package uz.itca.gm_aplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.itca.gm_aplication.entity.enums.ContractStatus;
import uz.itca.gm_aplication.entity.template.AbsEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contract extends AbsEntity {
    @Column(nullable = false)
    private String number;
    @ManyToOne(optional = false)
    private Client client;
    @Enumerated(EnumType.STRING)
    private ContractStatus status;
    @ManyToOne(optional = false)
    private Car car;
    @Column(nullable = false)
    private double price;
}

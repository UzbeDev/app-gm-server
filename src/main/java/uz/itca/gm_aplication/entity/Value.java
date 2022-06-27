package uz.itca.gm_aplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.itca.gm_aplication.entity.template.AbsNameEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Value extends AbsNameEntity {
    @ManyToOne
    private Detail detail;
    private String description;
}

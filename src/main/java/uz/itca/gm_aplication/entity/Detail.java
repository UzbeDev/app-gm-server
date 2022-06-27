package uz.itca.gm_aplication.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.itca.gm_aplication.entity.template.AbsNameEntity;

import javax.persistence.Entity;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Detail extends AbsNameEntity {

}

package uz.itca.gm_aplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import uz.itca.gm_aplication.entity.template.AbsNameEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Where(clause = "sell_active=true")
public class CarName extends AbsNameEntity {
    private boolean active = true;

    private boolean sellActive;
}

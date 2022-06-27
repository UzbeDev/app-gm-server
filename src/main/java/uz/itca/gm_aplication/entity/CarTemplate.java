package uz.itca.gm_aplication.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.itca.gm_aplication.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"car_name_id","position_id"}))
public class CarTemplate extends AbsEntity {

    @ManyToOne
    private CarName carName;

    @ManyToOne(optional = false)
    private Position position;

    private boolean active = true;

    @OneToMany(mappedBy = "carTemplate")
    private List<CarTemplateValue> carTemplateValues;

    public CarTemplate(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }
}

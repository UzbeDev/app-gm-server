package uz.itca.gm_aplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.itca.gm_aplication.entity.template.AbsEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"car_template_id","color_id"}))
public class Car extends AbsEntity {
    @ManyToOne(optional = false)
    private CarTemplate carTemplate;

    @ManyToOne(optional = false)
    private Color color;

    @OneToOne(optional = false)
    private Attachment photo;

    @Column(nullable = false)
    private double price;

    private boolean active = true;

}

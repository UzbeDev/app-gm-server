package uz.itca.gm_aplication.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.itca.gm_aplication.entity.Color;

@Projection(name = "customColor", types = Color.class)
public interface CustomColor {
    Integer getId();

    String getName();

    String getCode();
}

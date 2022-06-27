package uz.itca.gm_aplication.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.itca.gm_aplication.entity.CarName;

@Projection(name = "customCarName", types = CarName.class)
public interface CustomCarName {
    Integer getId();

    String getName();
}

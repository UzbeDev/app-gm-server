package uz.itca.gm_aplication.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.itca.gm_aplication.entity.Detail;

@Projection(name = "customDetail", types = Detail.class)
public interface CustomDetail {
    Integer getId();

    String getName();
}

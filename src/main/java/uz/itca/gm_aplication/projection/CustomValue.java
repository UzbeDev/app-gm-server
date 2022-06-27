package uz.itca.gm_aplication.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.itca.gm_aplication.entity.Value;

@Projection(name = "customValue", types = Value.class)
public interface CustomValue {
    Integer getId();

    String getName();
}

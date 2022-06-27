package uz.itca.gm_aplication.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.itca.gm_aplication.entity.Position;

@Projection(name = "customPosition", types = Position.class)
public interface CustomPosition {
    Integer getId();

    String getName();

    String getDescription();

}

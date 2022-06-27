package uz.itca.gm_aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import uz.itca.gm_aplication.entity.Color;
import uz.itca.gm_aplication.projection.CustomColor;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(path = "color", collectionResourceRel = "list", excerptProjection = CustomColor.class)
public interface ColorRepository extends JpaRepository<Color, Integer> {

    @RestResource(path = "getColorsByCarNameIdAndPositionId")
    @Query(value = "select * from color where id in(select color_id from car where  " +
            "active and car_template_id in(select id from car_template where " +
            "active and car_name_id=:carNameId and position_id=:positionId))", nativeQuery = true)
    List<Color> getColorsByPosition(@Param(value = "carNameId") Integer carNameId, @Param(value = "positionId") Integer positionId);

}

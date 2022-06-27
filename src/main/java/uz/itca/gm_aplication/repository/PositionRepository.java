package uz.itca.gm_aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import uz.itca.gm_aplication.entity.Position;
import uz.itca.gm_aplication.projection.CustomPosition;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(path = "position", collectionResourceRel = "list", excerptProjection = CustomPosition.class)
public interface PositionRepository extends JpaRepository<Position, Integer> {

    @RestResource(path = "getPositionsByCarName")
    @Query(value = "select * from position where id in(select position_id from car_template where active and car_name_id=:id)", nativeQuery = true)
    List<Position> getPositionsByCarName(@Param(value = "id") Integer id);

//    @RestResource(path = "getPositionsByCarName")
//    @Query(value = "select p from Position p where p.id =?1")
//    List<Position> getPositionsByCarNamek(Integer id);

}

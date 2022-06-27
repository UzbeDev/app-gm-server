package uz.itca.gm_aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import uz.itca.gm_aplication.entity.CarName;
import uz.itca.gm_aplication.projection.CustomCarName;

@CrossOrigin
@RepositoryRestResource(path = "carName", collectionResourceRel = "list", excerptProjection = CustomCarName.class)
public interface CarNameRepository extends JpaRepository<CarName, Integer> {

}

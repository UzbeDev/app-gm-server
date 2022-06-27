package uz.itca.gm_aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import uz.itca.gm_aplication.entity.Value;
import uz.itca.gm_aplication.projection.CustomValue;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(path = "value", collectionResourceRel = "list", excerptProjection = CustomValue.class)
public interface ValueRepository extends JpaRepository<Value, Integer> {

    @RestResource(path = "/byDetail")
    List<Value> findAllByDetailId(@Param("id") Integer id);

}

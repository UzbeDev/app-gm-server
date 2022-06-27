package uz.itca.gm_aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import uz.itca.gm_aplication.entity.Detail;
import uz.itca.gm_aplication.projection.CustomDetail;

@CrossOrigin
@RepositoryRestResource(path = "detail", collectionResourceRel = "list",excerptProjection = CustomDetail.class)
public interface DetailRepository extends JpaRepository<Detail, Integer> {
}

package uz.itca.gm_aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.itca.gm_aplication.entity.CarTemplateValue;

import java.util.UUID;

public interface CarTemplateValueRepository extends JpaRepository<CarTemplateValue, UUID> {
}

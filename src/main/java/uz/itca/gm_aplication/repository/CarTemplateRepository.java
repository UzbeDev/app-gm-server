package uz.itca.gm_aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.itca.gm_aplication.entity.CarTemplate;

import java.util.UUID;

public interface CarTemplateRepository extends JpaRepository<CarTemplate, UUID> {
}

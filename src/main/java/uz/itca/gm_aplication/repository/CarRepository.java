package uz.itca.gm_aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.itca.gm_aplication.entity.Car;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    Car findByColorIdAndCarTemplate_CarName_IdAndCarTemplate_Position_Id(Integer color_id, Integer carTemplate_carName_id, Integer carTemplate_position_id);

    @Query(value = "select * from car order by price desc", nativeQuery = true)
    List<Car> getByPriceSort();
}

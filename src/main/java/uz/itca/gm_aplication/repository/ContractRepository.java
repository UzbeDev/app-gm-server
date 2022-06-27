package uz.itca.gm_aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.itca.gm_aplication.entity.Contract;

import java.util.UUID;

public interface ContractRepository extends JpaRepository<Contract, UUID> {
    @Query(value = "select number from contract order by number desc limit 1", nativeQuery = true)
    String getMaxNumber();

}

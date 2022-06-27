package uz.itca.gm_aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.itca.gm_aplication.entity.Client;
import uz.itca.gm_aplication.entity.enums.PersonType;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
    Optional<Client> findByPassportSerialEqualsIgnoreCaseAndPassportNumberAndPersonType(String passportSerial, String passportNumber, PersonType personType);
    Optional<Client> findByPassportSerialEqualsIgnoreCaseAndPassportNumberAndPersonTypeAndIdNot(String passportSerial, String passportNumber, PersonType personType, UUID id);

}

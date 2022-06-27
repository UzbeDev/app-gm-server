package uz.itca.gm_aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.itca.gm_aplication.entity.Contact;

import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID> {
}

package uz.itca.gm_aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.itca.gm_aplication.entity.Attachment;

import java.util.UUID;

public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
}

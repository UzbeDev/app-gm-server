package uz.itca.gm_aplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.itca.gm_aplication.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AttachmentContent extends AbsEntity {
    @OneToOne
    private Attachment attachment;

    private byte[] content;
}

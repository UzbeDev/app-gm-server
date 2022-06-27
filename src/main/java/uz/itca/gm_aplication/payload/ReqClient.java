package uz.itca.gm_aplication.payload;

import lombok.Data;
import uz.itca.gm_aplication.entity.enums.GenderEnum;
import uz.itca.gm_aplication.entity.enums.PersonType;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Data
public class ReqClient {
    private UUID id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String tin;
    private String passportSerial;
    private String passportNumber;
    private Date birthDate;
    private GenderEnum gender;
    private ReqContact reqContact;
    @NotNull
    private PersonType personType;
    private String companyName;
    private String licenceNumber;
    private Date licenceExpire;
}

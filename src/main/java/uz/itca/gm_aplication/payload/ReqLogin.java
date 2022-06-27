package uz.itca.gm_aplication.payload;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class ReqLogin {
    @Pattern(regexp = "^[+][9][9][8][0-9]{9}$", message = "Phone number must be 13 digits.")
    private String phoneNumber;
    @Pattern(regexp = "^(?:(?=.*?\\p{N})(?=.*?[\\p{S}\\p{P} ])(?=.*?\\p{Lu})(?=.*?\\p{Ll}))[^\\p{C}]{4,16}$", message = "Uzunligi 8-16 oralig'ida. Parolda kamida bitta katta harf, son va belgi b'lishi shart.")
    private String password;

}

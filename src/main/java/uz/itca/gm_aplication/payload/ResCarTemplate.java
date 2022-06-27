package uz.itca.gm_aplication.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResCarTemplate {
    private UUID id;
    private String carName;
    private Integer carNameId;
    private String position;
    private Integer positionId;
    private List<ResSelectedValue> values;


}

package uz.itca.gm_aplication.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;


@Data
public class ReqCarTemplate {
    private UUID id;
    @NotNull
    private Integer carNameId;
    @NotNull
    private Integer positionId;
    @NotEmpty
    private List<Integer> values;
}

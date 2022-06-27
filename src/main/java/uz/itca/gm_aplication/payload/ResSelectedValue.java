package uz.itca.gm_aplication.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.itca.gm_aplication.entity.Value;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResSelectedValue {
    private Value[] values;
    private Integer selectedValueId;
}

package uz.itca.gm_aplication.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.itca.gm_aplication.entity.CarName;
import uz.itca.gm_aplication.entity.Color;
import uz.itca.gm_aplication.entity.Position;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResCar {
    private UUID id;
    private CarName carName;
    private Position position;
    private Color color;
    private UUID photoId;
    private double price;
    private boolean active;
    private String photoUrl;
}

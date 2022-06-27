package uz.itca.gm_aplication.payload;

import lombok.Data;

import java.util.UUID;


@Data
public class ReqCar {
    private UUID carTemplateId;
    private Integer colorId;
    private UUID photoId;
    private double price;
    private boolean active;
}

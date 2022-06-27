package uz.itca.gm_aplication.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class ReqContract {
    private ReqClient reqClient;
    private UUID carId;
}

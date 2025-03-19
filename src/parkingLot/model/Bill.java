package src.parkingLot.model;

import java.time.LocalDateTime;

public class Bill extends BaseModel {

    private Ticket ticket;
    private LocalDateTime exitTime;
    private Double amount;

}

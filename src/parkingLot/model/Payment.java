package src.parkingLot.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Payment extends BaseModel {
    private List<PaymentMode> paymentModes;
    private Bill bill;
    private Ticket ticket;
}

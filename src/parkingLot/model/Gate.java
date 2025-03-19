package src.parkingLot.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
public class Gate extends BaseModel {
    private GateType gatetype;
    private Operator operator;
}

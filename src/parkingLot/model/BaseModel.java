package src.parkingLot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseModel {

    private Integer id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}

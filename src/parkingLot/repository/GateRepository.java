package src.parkingLot.repository;

import src.parkingLot.model.Gate;
import src.parkingLot.model.GateType;
import src.parkingLot.model.Operator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {

    Map<Integer, Gate> map;

    public GateRepository () {
        map = new HashMap<>();

        Operator operator = new Operator();
        operator.setName("Ramesh");
        operator.setId(100);

        Gate gate = new Gate();
        gate.setId(1);
        gate.setOperator(operator);
        gate.setGatetype(GateType.ENTRY);

        map.put(1, gate);
    }

    public Optional<Gate> findGateById (Integer id) {
        return Optional.ofNullable(map.get(id));
    }
}

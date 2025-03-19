package src.parkingLot.repository;

import src.parkingLot.model.Operator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OperatorRepository {

    private Map<Integer, Operator> map;

    public OperatorRepository () {
        this.map = new HashMap<>();

        Operator operator = new Operator();
        operator.setName("Ramesh");
        operator.setId(100);

        map.put(100, operator);
    }

    public Optional<Operator> findOperatorById (Integer id) {
        return Optional.ofNullable(map.get(id));
    }
}

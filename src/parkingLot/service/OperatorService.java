package src.parkingLot.service;

import src.parkingLot.Exception.OperatorNotFoundException;
import src.parkingLot.model.Operator;
import src.parkingLot.repository.OperatorRepository;

public class OperatorService {

    private OperatorRepository operatorRepository;

    public OperatorService(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    public Operator findOperatorById (Integer id) throws OperatorNotFoundException {
        return operatorRepository.findOperatorById(id)
                .orElseThrow(() -> new OperatorNotFoundException("Operator was not found with id: " + id));
    }
}

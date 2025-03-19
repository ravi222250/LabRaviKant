package src.parkingLot.service;

import src.parkingLot.Exception.GateNotFoundException;
import src.parkingLot.model.Gate;
import src.parkingLot.repository.GateRepository;

public class GateService {

    private final GateRepository gateRepository;

    public GateService (GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public Gate findGateById (Integer gateId) throws GateNotFoundException {
        return gateRepository.findGateById(gateId)
                .orElseThrow(() -> new GateNotFoundException("Gate was not found with id: " + gateId));
    }
 }

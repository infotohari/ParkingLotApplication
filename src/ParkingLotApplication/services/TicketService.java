package ParkingLotApplication.services;

import ParkingLotApplication.exceptions.GateNotFoundException;
import ParkingLotApplication.models.Gate;
import ParkingLotApplication.models.Ticket;
import ParkingLotApplication.models.Vehicle;
import ParkingLotApplication.models.VehicleType;
import ParkingLotApplication.repositories.GateRepository;
import ParkingLotApplication.repositories.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;

    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public Ticket issueTicket(Long gateId,
                              String vehicleNumber,
                              String ownerName,
                              VehicleType vehicleType) throws GateNotFoundException {
        Ticket ticket = new Ticket();
        ticket.setCreatedAt(new Date());
        Optional<Gate> optionalGate = gateRepository.findGateById(gateId);

        if(optionalGate.isEmpty()){
            throw new GateNotFoundException();
        }

        Gate gate = optionalGate.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getOperator());

        Optional<Vehicle> optionalVehicle = vehicleRepository.findVehicleById(vehicleNumber);
        Vehicle savedVehicle ;

        if(optionalVehicle.isEmpty()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle.setOwnerName(ownerName);
            savedVehicle = vehicle;
            vehicleRepository.save();
        }else{
            savedVehicle = optionalVehicle.get();
        }
        ticket.setVehicle(savedVehicle);

        return ticket;
    }
}

package ParkingLotApplication.services;

import ParkingLotApplication.exceptions.GateNotFoundException;
import ParkingLotApplication.factories.SpotAssignmentStrategyFactory;
import ParkingLotApplication.models.*;
import ParkingLotApplication.repositories.GateRepository;
import ParkingLotApplication.repositories.ParkingLotRepository;
import ParkingLotApplication.repositories.TicketRepository;
import ParkingLotApplication.repositories.VehicleRepository;
import ParkingLotApplication.strategies.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(Long gateId,
                              String vehicleNumber,
                              String ownerName,
                              VehicleType vehicleType) throws GateNotFoundException {
        Ticket ticket = new Ticket();
        ticket.setCreatedAt(new Date());
        Optional<Gate> optionalGate = gateRepository.findGateById(gateId);

        if (optionalGate.isEmpty()) {
            throw new GateNotFoundException();
        }

        Gate gate = optionalGate.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getOperator());

        Optional<Vehicle> optionalVehicle = vehicleRepository.findVehicleById(vehicleNumber);
        Vehicle savedVehicle;

        if (optionalVehicle.isEmpty()) {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle.setOwnerName(ownerName);
            savedVehicle = vehicle;
            vehicleRepository.save();
        } else {
            savedVehicle = optionalVehicle.get();
        }
        ticket.setVehicle(savedVehicle);

        ParkingLot parkingLot = parkingLotRepository.getParkingLot();
        SpotAssignmentStrategyType spotAssignmentStrategyType = parkingLot.getSpotAssignmentStrategy();

        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.getSpotAssignmentStrategy(spotAssignmentStrategyType);

        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(vehicleType, gate);
            ticket.setParkingSpot(parkingSpot);
            ticket.setTicketNo("TICKET" + gateId + "_" + ticket.getGeneratedAt());
            ticketRepository.save(ticket);

        return ticket;
    }

}

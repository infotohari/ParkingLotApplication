package ParkingLotApplication;

import ParkingLotApplication.controllers.TicketController;
import ParkingLotApplication.dtos.IssueTicketRequestDTO;
import ParkingLotApplication.dtos.IssueTicketResponseDTO;
import ParkingLotApplication.dtos.ResponseStatus;
import ParkingLotApplication.models.Ticket;
import ParkingLotApplication.repositories.GateRepository;
import ParkingLotApplication.repositories.ParkingLotRepository;
import ParkingLotApplication.repositories.TicketRepository;
import ParkingLotApplication.repositories.VehicleRepository;
import ParkingLotApplication.services.TicketService;

public class Client {
    public static void main(String[] args) {
        TicketRepository ticketRepository = new TicketRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        GateRepository gateRepository = new GateRepository();

        TicketService ticketService = new TicketService(gateRepository, vehicleRepository,
                parkingLotRepository, ticketRepository);

        TicketController ticketController = new TicketController(ticketService);
        IssueTicketRequestDTO issueTicketRequestDTO = new IssueTicketRequestDTO();
        IssueTicketResponseDTO issueTicketResponseDTO = ticketController.issueTicket(issueTicketRequestDTO);

        if(issueTicketResponseDTO.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            Ticket ticket = issueTicketResponseDTO.getTicket();
            System.out.println("Ticket ID: " + ticket.getId());
        }else{

        }

    }
}

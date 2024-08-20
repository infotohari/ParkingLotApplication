package ParkingLotApplication.controllers;

import ParkingLotApplication.dtos.IssueTicketRequestDTO;
import ParkingLotApplication.dtos.IssueTicketResponseDTO;
import ParkingLotApplication.dtos.ResponseStatus;
import ParkingLotApplication.models.Ticket;
import ParkingLotApplication.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO issueTicketRequestDTO){
            IssueTicketResponseDTO issueTicketResponseDTO = new IssueTicketResponseDTO();

            try {
                Ticket ticket = ticketService.issueTicket(issueTicketRequestDTO.getGateId(),
                        issueTicketRequestDTO.getVehicleNumber(),
                        issueTicketRequestDTO.getOwnerName(),
                        issueTicketRequestDTO.getVehicleType());

                issueTicketResponseDTO.setTicket(ticket);
                issueTicketResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            }
            catch (Exception ex){
                ex.getMessage();
                issueTicketResponseDTO.setResponseStatus(ResponseStatus.FAILED);
            }

            return issueTicketResponseDTO;

    }
}

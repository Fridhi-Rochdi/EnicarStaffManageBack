package tn.enicarthage.staffmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.enicarthage.staffmanager.model.Ticket;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponse {
    private Long id;
    private String title;
    private String description;
    private String fileType;
    private Integer totalNumber;
    private String fileName;
    private String filePath;
    private String actProf; // Owner name
    private Long ownerId;
    private String status;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public static TicketResponse fromTicket(Ticket ticket) {
        TicketResponse response = new TicketResponse();
        response.setId(ticket.getId());
        response.setTitle(ticket.getTitle());
        response.setDescription(ticket.getDescription());
        response.setFileType(ticket.getFileType().getLabel());
        response.setTotalNumber(ticket.getTotalNumber());
        response.setFileName(ticket.getFileName());
        response.setFilePath(ticket.getFilePath());
        response.setActProf(ticket.getOwner().getFirstName() + " " + ticket.getOwner().getLastName());
        response.setOwnerId(ticket.getOwner().getId());
        response.setStatus(ticket.getStatus().getLabel());
        response.setCreatedDate(ticket.getCreatedDate());
        response.setUpdatedDate(ticket.getUpdatedDate());
        return response;
    }
}

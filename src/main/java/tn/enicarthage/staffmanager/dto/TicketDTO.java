package tn.enicarthage.staffmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.enicarthage.staffmanager.model.TicketStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private Long id;
    private String title;
    private String description;
    private String actProf;
    private Integer totalNumber;
    private String fileName;
    private TicketStatus status;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private String name; // User name who created the ticket
}

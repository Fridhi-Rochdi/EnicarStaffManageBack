package tn.enicarthage.staffmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.enicarthage.staffmanager.model.TicketStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketUpdateRequest {
    private String title;
    private String description;
    private String actProf;
    private Integer totalNumber;
    private TicketStatus status;
}

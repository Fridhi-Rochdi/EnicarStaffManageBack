package tn.enicarthage.staffmanager.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.enicarthage.staffmanager.model.Ticket;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketRequest {

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 200, message = "Title must be between 3 and 200 characters")
    private String title;

    private String description;

    @NotNull(message = "File type is required")
    private Ticket.FileType fileType;

    @NotNull(message = "Total number is required")
    @Min(value = 1, message = "Total number must be at least 1")
    @Max(value = 200, message = "Total number cannot exceed 200")
    private Integer totalNumber;

    private String fileName;

    private String filePath;
}

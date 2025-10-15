package tn.enicarthage.staffmanager.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketCreateRequest {

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 200, message = "Title must be between 3 and 200 characters")
    private String title;

    @NotBlank(message = "Description/Type is required")
    private String description;

    @NotBlank(message = "Professor name is required")
    private String actProf;

    @NotNull(message = "Total number of copies is required")
    @Min(value = 1, message = "Number of copies must be at least 1")
    @Max(value = 500, message = "Number of copies cannot exceed 500")
    private Integer totalNumber;
}

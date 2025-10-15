package tn.enicarthage.staffmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamPeriodDTO {
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean active;
    private String description;
    private LocalDateTime createdAt;
}

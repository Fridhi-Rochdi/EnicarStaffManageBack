package tn.enicarthage.staffmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomReservationDTO {
    private Long id;
    private String roomName;
    private LocalDate reservationDate;
    private String startTime;
    private String endTime;
    private String purpose;
    private String equipmentNeeded;
    private String status;
    private String adminComment;
    private UserDTO user;
    private String userEmail; // For easy access
    private LocalDateTime createdAt;
}

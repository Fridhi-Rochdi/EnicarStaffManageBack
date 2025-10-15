package tn.enicarthage.staffmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomReservationRequest {
    @NotBlank(message = "Room name is required")
    private String roomName;

    @NotNull(message = "Reservation date is required")
    private LocalDate reservationDate;

    @NotBlank(message = "Start time is required")
    private String startTime;

    @NotBlank(message = "End time is required")
    private String endTime;

    @NotBlank(message = "Purpose is required")
    private String purpose;

    private String equipmentNeeded;
}

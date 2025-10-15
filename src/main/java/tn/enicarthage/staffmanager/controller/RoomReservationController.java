package tn.enicarthage.staffmanager.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.staffmanager.dto.RoomReservationDTO;
import tn.enicarthage.staffmanager.dto.RoomReservationRequest;
import tn.enicarthage.staffmanager.dto.UserDTO;
import tn.enicarthage.staffmanager.model.RoomReservation;
import tn.enicarthage.staffmanager.model.User;
import tn.enicarthage.staffmanager.service.RoomReservationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/room-reservations")
@CrossOrigin(origins = "*")
public class RoomReservationController {

    @Autowired
    private RoomReservationService reservationService;

    @PostMapping
    public ResponseEntity<RoomReservationDTO> createReservation(
            @Valid @RequestBody RoomReservationRequest request,
            @AuthenticationPrincipal User user) {
        
        RoomReservation reservation = new RoomReservation();
        reservation.setRoomName(request.getRoomName());
        reservation.setReservationDate(request.getReservationDate());
        reservation.setStartTime(request.getStartTime());
        reservation.setEndTime(request.getEndTime());
        reservation.setPurpose(request.getPurpose());
        reservation.setEquipmentNeeded(request.getEquipmentNeeded());

        RoomReservation created = reservationService.createReservation(reservation, user.getEmail());
        return ResponseEntity.ok(convertToDTO(created));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<RoomReservationDTO>> getAllReservations() {
        List<RoomReservationDTO> reservations = reservationService.getAllReservations()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/my-reservations")
    public ResponseEntity<List<RoomReservationDTO>> getMyReservations(@AuthenticationPrincipal User user) {
        List<RoomReservationDTO> reservations = reservationService.getReservationsByUser(user.getId())
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomReservationDTO> getReservationById(@PathVariable Long id) {
        RoomReservation reservation = reservationService.getReservationById(id);
        return ResponseEntity.ok(convertToDTO(reservation));
    }

    @GetMapping("/status/{status}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<RoomReservationDTO>> getReservationsByStatus(@PathVariable String status) {
        RoomReservation.ReservationStatus reservationStatus = RoomReservation.ReservationStatus.valueOf(status);
        List<RoomReservationDTO> reservations = reservationService.getReservationsByStatus(reservationStatus)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reservations);
    }

    @PutMapping("/{id}/validate")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RoomReservationDTO> validateReservation(
            @PathVariable Long id,
            @RequestBody(required = false) String comment) {
        RoomReservation updated = reservationService.updateReservationStatus(
                id, RoomReservation.ReservationStatus.VALIDEE, comment);
        return ResponseEntity.ok(convertToDTO(updated));
    }

    @PutMapping("/{id}/reject")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RoomReservationDTO> rejectReservation(
            @PathVariable Long id,
            @RequestBody(required = false) String comment) {
        RoomReservation updated = reservationService.updateReservationStatus(
                id, RoomReservation.ReservationStatus.REFUSEE, comment);
        return ResponseEntity.ok(convertToDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.ok().build();
    }

    private RoomReservationDTO convertToDTO(RoomReservation reservation) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(reservation.getUser().getId());
        userDTO.setEmail(reservation.getUser().getEmail());
        userDTO.setName(reservation.getUser().getFirstName() + " " + reservation.getUser().getLastName());
        userDTO.setActive(reservation.getUser().getActive());

        RoomReservationDTO dto = new RoomReservationDTO();
        dto.setId(reservation.getId());
        dto.setRoomName(reservation.getRoomName());
        dto.setReservationDate(reservation.getReservationDate());
        dto.setStartTime(reservation.getStartTime());
        dto.setEndTime(reservation.getEndTime());
        dto.setPurpose(reservation.getPurpose());
        dto.setEquipmentNeeded(reservation.getEquipmentNeeded());
        dto.setStatus(reservation.getStatus().name());
        dto.setAdminComment(reservation.getAdminComment());
        dto.setUser(userDTO);
        dto.setUserEmail(reservation.getUser().getEmail());
        dto.setCreatedAt(reservation.getCreatedAt());
        
        return dto;
    }
}

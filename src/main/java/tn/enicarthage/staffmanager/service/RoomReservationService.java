package tn.enicarthage.staffmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.enicarthage.staffmanager.model.RoomReservation;
import tn.enicarthage.staffmanager.model.User;
import tn.enicarthage.staffmanager.repository.RoomReservationRepository;
import tn.enicarthage.staffmanager.repository.UserRepository;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoomReservationService {

    @Autowired
    private RoomReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public RoomReservation createReservation(RoomReservation reservation, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        reservation.setUser(user);
        reservation.setStatus(RoomReservation.ReservationStatus.EN_ATTENTE);
        
        return reservationRepository.save(reservation);
    }

    public List<RoomReservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public RoomReservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    public List<RoomReservation> getReservationsByUser(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

    public List<RoomReservation> getReservationsByStatus(RoomReservation.ReservationStatus status) {
        return reservationRepository.findByStatus(status);
    }

    @Transactional
    public RoomReservation updateReservationStatus(Long id, RoomReservation.ReservationStatus status, String adminComment) {
        RoomReservation reservation = getReservationById(id);
        reservation.setStatus(status);
        if (adminComment != null) {
            reservation.setAdminComment(adminComment);
        }
        return reservationRepository.save(reservation);
    }

    @Transactional
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public List<RoomReservation> getReservationsByDateRange(LocalDate start, LocalDate end) {
        return reservationRepository.findByReservationDateBetween(start, end);
    }

    public boolean isRoomAvailable(String roomName, LocalDate date, String startTime, String endTime) {
        List<RoomReservation> existingReservations = reservationRepository
                .findByRoomNameAndReservationDate(roomName, date);
        
        for (RoomReservation reservation : existingReservations) {
            if (reservation.getStatus() == RoomReservation.ReservationStatus.VALIDEE) {
                // Check for time overlap
                if (timesOverlap(startTime, endTime, reservation.getStartTime(), reservation.getEndTime())) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean timesOverlap(String start1, String end1, String start2, String end2) {
        // Simple string comparison assuming format HH:mm
        return !(end1.compareTo(start2) <= 0 || start1.compareTo(end2) >= 0);
    }
}

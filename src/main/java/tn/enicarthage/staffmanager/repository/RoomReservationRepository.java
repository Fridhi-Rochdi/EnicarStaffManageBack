package tn.enicarthage.staffmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enicarthage.staffmanager.model.RoomReservation;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomReservationRepository extends JpaRepository<RoomReservation, Long> {
    List<RoomReservation> findByUserId(Long userId);
    List<RoomReservation> findByStatus(RoomReservation.ReservationStatus status);
    List<RoomReservation> findByReservationDateBetween(LocalDate start, LocalDate end);
    List<RoomReservation> findByRoomNameAndReservationDate(String roomName, LocalDate date);
}

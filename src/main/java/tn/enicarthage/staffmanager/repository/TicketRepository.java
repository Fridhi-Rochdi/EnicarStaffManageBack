package tn.enicarthage.staffmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enicarthage.staffmanager.model.Ticket;
import tn.enicarthage.staffmanager.model.User;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByOwner(User owner);
    List<Ticket> findByStatus(Ticket.Status status);
    List<Ticket> findByFileType(Ticket.FileType fileType);
}

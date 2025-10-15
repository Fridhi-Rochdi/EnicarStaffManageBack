package tn.enicarthage.staffmanager.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.enicarthage.staffmanager.dto.TicketRequest;
import tn.enicarthage.staffmanager.dto.TicketResponse;
import tn.enicarthage.staffmanager.model.Ticket;
import tn.enicarthage.staffmanager.model.User;
import tn.enicarthage.staffmanager.repository.TicketRepository;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketService {

    private final TicketRepository ticketRepository;
    private final AuthService authService;
    private final MinioStorageService minioStorageService;

    public TicketResponse createTicket(TicketRequest request, MultipartFile file) {
        User currentUser = authService.getCurrentUser();

        Ticket ticket = new Ticket();
        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());
        ticket.setFileType(request.getFileType());
        ticket.setTotalNumber(request.getTotalNumber());
        ticket.setOwner(currentUser);
        ticket.setStatus(Ticket.Status.EN_ATTENTE);

        if (file != null && !file.isEmpty()) {
            try {
                // Upload file to MinIO
                String objectName = minioStorageService.uploadFile(file, "tickets");
                ticket.setFileName(file.getOriginalFilename());
                ticket.setFilePath(objectName); // Store MinIO object path
                log.info("File uploaded to MinIO: {}", objectName);
            } catch (Exception e) {
                log.error("Error uploading file to MinIO: {}", e.getMessage());
                throw new RuntimeException("Failed to upload file", e);
            }
        }

        Ticket savedTicket = ticketRepository.save(ticket);
        return TicketResponse.fromTicket(savedTicket);
    }

    public List<TicketResponse> getAllTickets() {
        return ticketRepository.findAll().stream()
                .map(TicketResponse::fromTicket)
                .collect(Collectors.toList());
    }

    public List<TicketResponse> getMyTickets() {
        User currentUser = authService.getCurrentUser();
        return ticketRepository.findByOwner(currentUser).stream()
                .map(TicketResponse::fromTicket)
                .collect(Collectors.toList());
    }

    public TicketResponse getTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + id));
        return TicketResponse.fromTicket(ticket);
    }

    public TicketResponse updateTicket(Long id, TicketRequest request, MultipartFile file) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + id));

        User currentUser = authService.getCurrentUser();
        if (!ticket.getOwner().getId().equals(currentUser.getId()) &&
                !currentUser.getRole().equals(User.Role.ADMIN)) {
            throw new RuntimeException("You don't have permission to update this ticket");
        }

        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());
        ticket.setFileType(request.getFileType());
        ticket.setTotalNumber(request.getTotalNumber());

        if (file != null && !file.isEmpty()) {
            try {
                // Delete old file from MinIO if exists
                if (ticket.getFilePath() != null && !ticket.getFilePath().isEmpty()) {
                    try {
                        minioStorageService.deleteFile(ticket.getFilePath());
                        log.info("Old file deleted from MinIO: {}", ticket.getFilePath());
                    } catch (Exception e) {
                        log.warn("Could not delete old file: {}", e.getMessage());
                    }
                }

                // Upload new file to MinIO
                String objectName = minioStorageService.uploadFile(file, "tickets");
                ticket.setFileName(file.getOriginalFilename());
                ticket.setFilePath(objectName);
                log.info("New file uploaded to MinIO: {}", objectName);
            } catch (Exception e) {
                log.error("Error updating file in MinIO: {}", e.getMessage());
                throw new RuntimeException("Failed to update file", e);
            }
        }

        Ticket updatedTicket = ticketRepository.save(ticket);
        return TicketResponse.fromTicket(updatedTicket);
    }

    public TicketResponse updateTicketStatus(Long id, Ticket.Status status) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + id));

        ticket.setStatus(status);
        Ticket updatedTicket = ticketRepository.save(ticket);
        return TicketResponse.fromTicket(updatedTicket);
    }

    public void deleteTicket(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + id));

        User currentUser = authService.getCurrentUser();
        if (!ticket.getOwner().getId().equals(currentUser.getId()) &&
                !currentUser.getRole().equals(User.Role.ADMIN)) {
            throw new RuntimeException("You don't have permission to delete this ticket");
        }

        // Delete file from MinIO if exists
        if (ticket.getFilePath() != null && !ticket.getFilePath().isEmpty()) {
            try {
                minioStorageService.deleteFile(ticket.getFilePath());
                log.info("File deleted from MinIO: {}", ticket.getFilePath());
            } catch (Exception e) {
                log.warn("Could not delete file from MinIO: {}", e.getMessage());
            }
        }

        ticketRepository.delete(ticket);
    }

    /**
     * Get presigned URL for downloading file
     */
    public String getFileDownloadUrl(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + ticketId));

        if (ticket.getFilePath() == null || ticket.getFilePath().isEmpty()) {
            throw new RuntimeException("No file associated with this ticket");
        }

        try {
            // Generate presigned URL valid for 60 minutes
            return minioStorageService.getPresignedUrl(ticket.getFilePath(), 60);
        } catch (Exception e) {
            log.error("Error generating download URL: {}", e.getMessage());
            throw new RuntimeException("Failed to generate download URL", e);
        }
    }

    /**
     * Download file as stream from MinIO
     */
    public InputStream downloadFile(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + ticketId));

        if (ticket.getFilePath() == null || ticket.getFilePath().isEmpty()) {
            throw new RuntimeException("No file associated with this ticket");
        }

        try {
            return minioStorageService.getFile(ticket.getFilePath());
        } catch (Exception e) {
            log.error("Error downloading file from MinIO: {}", e.getMessage());
            throw new RuntimeException("Failed to download file", e);
        }
    }
}

package tn.enicarthage.staffmanager.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.enicarthage.staffmanager.dto.ApiResponse;
import tn.enicarthage.staffmanager.dto.TicketRequest;
import tn.enicarthage.staffmanager.dto.TicketResponse;
import tn.enicarthage.staffmanager.model.Ticket;
import tn.enicarthage.staffmanager.service.TicketService;

import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<?> createTicket(
            @Valid @RequestPart("ticket") TicketRequest request,
            @RequestPart(value = "file", required = false) MultipartFile file) {
        try {
            TicketResponse response = ticketService.createTicket(request, file);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(ApiResponse.success("Ticket created successfully", response));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error(e.getMessage()));
        }
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF')")
    public ResponseEntity<?> getAllTickets() {
        try {
            List<TicketResponse> tickets = ticketService.getAllTickets();
            return ResponseEntity.ok(ApiResponse.success("Tickets retrieved successfully", tickets));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(e.getMessage()));
        }
    }

    @GetMapping("/my-tickets")
    public ResponseEntity<?> getMyTickets() {
        try {
            List<TicketResponse> tickets = ticketService.getMyTickets();
            return ResponseEntity.ok(ApiResponse.success("Your tickets retrieved successfully", tickets));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTicketById(@PathVariable Long id) {
        try {
            TicketResponse ticket = ticketService.getTicketById(id);
            return ResponseEntity.ok(ApiResponse.success("Ticket retrieved successfully", ticket));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTicket(
            @PathVariable Long id,
            @Valid @RequestPart("ticket") TicketRequest request,
            @RequestPart(value = "file", required = false) MultipartFile file) {
        try {
            TicketResponse response = ticketService.updateTicket(id, request, file);
            return ResponseEntity.ok(ApiResponse.success("Ticket updated successfully", response));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error(e.getMessage()));
        }
    }

    @PatchMapping("/{id}/status")
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF')")
    public ResponseEntity<?> updateTicketStatus(
            @PathVariable Long id,
            @RequestParam Ticket.Status status) {
        try {
            TicketResponse response = ticketService.updateTicketStatus(id, status);
            return ResponseEntity.ok(ApiResponse.success("Ticket status updated successfully", response));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable Long id) {
        try {
            ticketService.deleteTicket(id);
            return ResponseEntity.ok(ApiResponse.success("Ticket deleted successfully"));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}/download-url")
    public ResponseEntity<?> getFileDownloadUrl(@PathVariable Long id) {
        try {
            String downloadUrl = ticketService.getFileDownloadUrl(id);
            return ResponseEntity.ok(ApiResponse.success("Download URL generated", downloadUrl));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error(e.getMessage()));
        }
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id) {
        try {
            // Get ticket to extract file info
            TicketResponse ticket = ticketService.getTicketById(id);
            
            if (ticket.getFileName() == null || ticket.getFilePath() == null) {
                throw new RuntimeException("No file attached to this ticket");
            }

            // Get file from MinIO via service
            byte[] fileBytes;
            try (InputStream fileStream = ticketService.downloadFile(id)) {
                fileBytes = fileStream.readAllBytes();
            }
            
            // Determine content type - validate it's a valid MIME type
            String contentType = "application/octet-stream"; // default
            if (ticket.getFileType() != null && ticket.getFileType().contains("/")) {
                try {
                    MediaType.parseMediaType(ticket.getFileType()); // validate
                    contentType = ticket.getFileType();
                } catch (Exception e) {
                    System.err.println("Invalid MIME type '" + ticket.getFileType() + "', using default");
                }
            } else {
                // Try to determine from file extension
                String fileName = ticket.getFileName().toLowerCase();
                if (fileName.endsWith(".pdf")) {
                    contentType = "application/pdf";
                } else if (fileName.endsWith(".png")) {
                    contentType = "image/png";
                } else if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
                    contentType = "image/jpeg";
                } else if (fileName.endsWith(".doc")) {
                    contentType = "application/msword";
                } else if (fileName.endsWith(".docx")) {
                    contentType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
                } else if (fileName.endsWith(".txt")) {
                    contentType = "text/plain";
                }
            }

            // Create resource from bytes
            ByteArrayResource resource = new ByteArrayResource(fileBytes);

            // Set headers for download
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, 
                "attachment; filename=\"" + ticket.getFileName() + "\"");
            headers.add(HttpHeaders.CONTENT_LENGTH, String.valueOf(fileBytes.length));

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.parseMediaType(contentType))
                    .body(resource);
                    
        } catch (Exception e) {
            // Log the error
            System.err.println("Error downloading file for ticket " + id + ": " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to download file: " + e.getMessage(), e);
        }
    }
}

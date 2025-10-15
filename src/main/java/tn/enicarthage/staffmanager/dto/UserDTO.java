package tn.enicarthage.staffmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.enicarthage.staffmanager.model.UserRole;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String firstName;
    private String lastName;
    private UserRole role;
    private String department;
    private boolean active;
    private LocalDateTime createdDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

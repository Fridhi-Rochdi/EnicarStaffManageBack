package tn.enicarthage.staffmanager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    
    @NotBlank(message = "Email est obligatoire")
    @Email(message = "Email invalide")
    private String email;
    
    @NotBlank(message = "Le prénom est obligatoire")
    private String firstName;
    
    @NotBlank(message = "Le nom est obligatoire")
    private String lastName;
    
    @NotBlank(message = "Le rôle est obligatoire")
    private String role; // ADMIN, PROFESSOR, STAFF
    
    @NotNull(message = "Le statut actif est obligatoire")
    private Boolean active;
    
    // Mot de passe optionnel - seulement si on veut le changer
    private String password;
}

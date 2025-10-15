package tn.enicarthage.staffmanager.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.enicarthage.staffmanager.dto.CreateUserRequest;
import tn.enicarthage.staffmanager.dto.UpdateUserRequest;
import tn.enicarthage.staffmanager.dto.UserDTO;
import tn.enicarthage.staffmanager.model.User;
import tn.enicarthage.staffmanager.model.UserRole;
import tn.enicarthage.staffmanager.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserDTO> getAllUsers() {
        log.debug("Getting all users");
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        log.debug("Getting user by id: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID: " + id));
        return convertToDTO(user);
    }

    @Transactional
    public UserDTO createUser(CreateUserRequest request) {
        log.debug("Creating user with email: {}", request.getEmail());
        
        // Vérifier si l'email existe déjà
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Un utilisateur avec cet email existe déjà");
        }

        // Valider le rôle
        User.Role role;
        try {
            role = User.Role.valueOf(request.getRole().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Rôle invalide: " + request.getRole());
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);
        user.setActive(request.getActive());

        User savedUser = userRepository.save(user);
        log.info("User created successfully with id: {}", savedUser.getId());
        
        return convertToDTO(savedUser);
    }

    @Transactional
    public UserDTO updateUser(Long id, UpdateUserRequest request) {
        log.debug("Updating user with id: {}", id);
        
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID: " + id));

        // Vérifier si le nouvel email existe déjà (sauf si c'est le même utilisateur)
        if (!user.getEmail().equals(request.getEmail())) {
            if (userRepository.findByEmail(request.getEmail()).isPresent()) {
                throw new RuntimeException("Un utilisateur avec cet email existe déjà");
            }
        }

        // Valider le rôle
        User.Role role;
        try {
            role = User.Role.valueOf(request.getRole().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Rôle invalide: " + request.getRole());
        }

        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setRole(role);
        user.setActive(request.getActive());

        // Mettre à jour le mot de passe seulement s'il est fourni
        if (request.getPassword() != null && !request.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }

        User updatedUser = userRepository.save(user);
        log.info("User updated successfully with id: {}", updatedUser.getId());
        
        return convertToDTO(updatedUser);
    }

    @Transactional
    public void deleteUser(Long id) {
        log.debug("Deleting user with id: {}", id);
        
        // Récupérer l'utilisateur actuellement connecté
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();
        
        User userToDelete = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID: " + id));

        // Empêcher l'utilisateur de se supprimer lui-même
        if (userToDelete.getEmail().equals(currentUserEmail)) {
            throw new RuntimeException("Vous ne pouvez pas supprimer votre propre compte");
        }

        userRepository.delete(userToDelete);
        log.info("User deleted successfully with id: {}", id);
    }

    @Transactional
    public UserDTO toggleUserStatus(Long id) {
        log.debug("Toggling user status with id: {}", id);
        
        // Récupérer l'utilisateur actuellement connecté
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();
        
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID: " + id));

        // Empêcher l'utilisateur de désactiver son propre compte
        if (user.getEmail().equals(currentUserEmail) && user.getActive()) {
            throw new RuntimeException("Vous ne pouvez pas désactiver votre propre compte");
        }

        user.setActive(!user.getActive());
        User updatedUser = userRepository.save(user);
        log.info("User status toggled successfully with id: {}", id);
        
        return convertToDTO(updatedUser);
    }

    public List<UserDTO> getUsersByRole(String roleName) {
        log.debug("Getting users by role: {}", roleName);
        
        User.Role role;
        try {
            role = User.Role.valueOf(roleName.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Rôle invalide: " + roleName);
        }

        return userRepository.findByRole(role).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setName(user.getFirstName() + " " + user.getLastName());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setRole(user.getRole() == User.Role.ADMIN ? UserRole.ADMIN : 
                    user.getRole() == User.Role.PROFESSOR ? UserRole.PROFESSOR : UserRole.STAFF);
        dto.setActive(user.getActive());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        dto.setCreatedDate(user.getCreatedAt());
        return dto;
    }
}

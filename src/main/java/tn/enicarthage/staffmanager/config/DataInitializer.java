package tn.enicarthage.staffmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tn.enicarthage.staffmanager.model.User;
import tn.enicarthage.staffmanager.repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Create default admin user if not exists
        if (!userRepository.existsByEmail("admin@enicarthage.tn")) {
            User admin = new User();
            admin.setEmail("admin@enicarthage.tn");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setFirstName("Admin");
            admin.setLastName("ENICarthage");
            admin.setRole(User.Role.ADMIN);
            admin.setActive(true);
            userRepository.save(admin);
            System.out.println("Default admin user created: admin@enicarthage.tn / admin123");
        }

        // Create default professor user if not exists
        if (!userRepository.existsByEmail("prof.dupont@enicarthage.tn")) {
            User professor = new User();
            professor.setEmail("prof.dupont@enicarthage.tn");
            professor.setPassword(passwordEncoder.encode("prof123"));
            professor.setFirstName("Jean");
            professor.setLastName("Dupont");
            professor.setRole(User.Role.PROFESSOR);
            professor.setActive(true);
            userRepository.save(professor);
            System.out.println("Default professor user created: prof.dupont@enicarthage.tn / prof123");
        }

        // Create default staff user if not exists
        if (!userRepository.existsByEmail("staff@enicarthage.tn")) {
            User staff = new User();
            staff.setEmail("staff@enicarthage.tn");
            staff.setPassword(passwordEncoder.encode("staff123"));
            staff.setFirstName("Staff");
            staff.setLastName("Member");
            staff.setRole(User.Role.STAFF);
            staff.setActive(true);
            userRepository.save(staff);
            System.out.println("Default staff user created: staff@enicarthage.tn / staff123");
        }
    }
}

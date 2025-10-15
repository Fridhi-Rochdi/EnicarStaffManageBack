package tn.enicarthage.staffmanager.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TestController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint - No authentication required!";
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "Server is running!";
    }
}

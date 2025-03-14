package com.beautyfullcare.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @PostMapping("/services")
    @PreAuthorize("hasRole('ADMIN')")
    public String createService() {
        // TODO: Implement service creation
        return "Service created";
    }

    @PutMapping("/services/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateService(@PathVariable Long id) {
        // TODO: Implement service update
        return "Service updated";
    }

    @DeleteMapping("/services/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteService(@PathVariable Long id) {
        // TODO: Implement service deletion
        return "Service deleted";
    }

    @PostMapping("/therapists")
    @PreAuthorize("hasRole('ADMIN')")
    public String createTherapist() {
        // TODO: Implement therapist creation
        return "Therapist created";
    }

    @PutMapping("/therapists/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateTherapist(@PathVariable Long id) {
        // TODO: Implement therapist update
        return "Therapist updated";
    }

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public String getDashboardData() {
        // TODO: Implement dashboard data retrieval
        return "Dashboard data";
    }
}

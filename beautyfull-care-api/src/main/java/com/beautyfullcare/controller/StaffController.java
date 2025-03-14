package com.beautyfullcare.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @PutMapping("/bookings/{id}/checkin")
    @PreAuthorize("hasRole('STAFF')")
    public String checkInCustomer(@PathVariable Long id) {
        // TODO: Implement check-in logic
        return "Customer checked in";
    }

    @PutMapping("/bookings/{id}/assign")
    @PreAuthorize("hasRole('STAFF')")
    public String assignTherapist(@PathVariable Long id) {
        // TODO: Implement therapist assignment
        return "Therapist assigned";
    }

    @PutMapping("/bookings/{id}/result")
    @PreAuthorize("hasRole('STAFF')")
    public String recordServiceResult(@PathVariable Long id) {
        // TODO: Implement service result recording
        return "Service result recorded";
    }

    @PutMapping("/bookings/{id}/checkout")
    @PreAuthorize("hasRole('STAFF')")
    public String checkOutCustomer(@PathVariable Long id) {
        // TODO: Implement check-out logic
        return "Customer checked out";
    }
}

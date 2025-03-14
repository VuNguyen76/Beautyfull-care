package com.beautyfullcare.controller;

import com.beautyfullcare.dto.BookingRequest;
import com.beautyfullcare.dto.FeedbackRequest;
import com.beautyfullcare.entity.Booking;
import com.beautyfullcare.entity.Feedback;
import com.beautyfullcare.entity.User;
import com.beautyfullcare.exception.ResourceNotFoundException;
import com.beautyfullcare.repository.UserRepository;
import com.beautyfullcare.service.BookingService;
import com.beautyfullcare.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
        private final UserRepository userRepository;
        private final BookingService bookingService;
        private final FeedbackService feedbackService;

        @GetMapping("/me")
        @PreAuthorize("hasRole('CUSTOMER')")
        public ResponseEntity<?> getCustomerProfile(Principal principal) {
                String username = principal.getName();
                return userRepository.findByUsername(username)
                                .map(user -> ResponseEntity.ok(Map.of(
                                                "id", user.getId(),
                                                "username", user.getUsername(),
                                                "fullName", user.getFullName(),
                                                "email", user.getEmail(),
                                                "phone", user.getPhone())))
                                .orElse(ResponseEntity.notFound().build());
        }

        @GetMapping("/me/bookings")
        @PreAuthorize("hasRole('CUSTOMER')")
        public ResponseEntity<List<Booking>> getCustomerBookings(Principal principal) {
                String username = principal.getName();
                User customer = userRepository.findByUsername(username)
                                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
                List<Booking> bookings = bookingService.getCustomerBookings(customer.getId());
                return ResponseEntity.ok(bookings);
        }

        @PostMapping("/bookings")
        @PreAuthorize("hasRole('CUSTOMER')")
        public ResponseEntity<Booking> createBooking(
                        @RequestBody BookingRequest request,
                        Principal principal) {
                String username = principal.getName();
                User customer = userRepository.findByUsername(username)
                                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

                Booking booking = bookingService.createBooking(
                                customer.getId(),
                                request.getServiceId(),
                                request.getTherapistId(),
                                request.getBookingTime(),
                                request.getNotes());

                return ResponseEntity.status(HttpStatus.CREATED).body(booking);
        }

        @PostMapping("/feedback")
        @PreAuthorize("hasRole('CUSTOMER')")
        public ResponseEntity<Feedback> submitFeedback(
                        @RequestBody FeedbackRequest request,
                        Principal principal) {
                String username = principal.getName();
                User customer = userRepository.findByUsername(username)
                                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

                Feedback feedback = feedbackService.submitFeedback(
                                customer.getId(),
                                request.getServiceId(),
                                request.getTherapistId(),
                                request.getRating(),
                                request.getComment());

                return ResponseEntity.status(HttpStatus.CREATED).body(feedback);
        }
}

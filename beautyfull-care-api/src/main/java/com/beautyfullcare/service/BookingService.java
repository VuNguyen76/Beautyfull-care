package com.beautyfullcare.service;

import com.beautyfullcare.entity.Booking;
import com.beautyfullcare.entity.BeautyService;
import com.beautyfullcare.entity.User;
import com.beautyfullcare.exception.ResourceNotFoundException;
import com.beautyfullcare.repository.BookingRepository;
import com.beautyfullcare.repository.BeautyServiceRepository;
import com.beautyfullcare.repository.SpecialistRepository;
import com.beautyfullcare.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
        private final BookingRepository bookingRepository;
        private final UserRepository userRepository;
        private final BeautyServiceRepository beautyServiceRepository;
        private final SpecialistRepository specialistRepository;

        public Booking createBooking(Long customerId, Long serviceId, Long therapistId,
                        LocalDateTime bookingTime, String notes) {
                User customer = userRepository.findById(customerId)
                                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

                BeautyService service = beautyServiceRepository.findById(serviceId)
                                .orElseThrow(() -> new ResourceNotFoundException("Service not found"));

                Booking booking = new Booking();
                booking.setCustomer(customer);
                booking.setService(service);
                booking.setBookingTime(bookingTime);
                booking.setNotes(notes);
                booking.setStatus("PENDING");

                if (therapistId != null) {
                        booking.setTherapist(specialistRepository.findById(therapistId)
                                        .orElseThrow(() -> new ResourceNotFoundException("Therapist not found")));
                }

                return bookingRepository.save(booking);
        }

        public List<Booking> getCustomerBookings(Long customerId) {
                User customer = userRepository.findById(customerId)
                                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
                return bookingRepository.findByCustomer(customer);
        }
}

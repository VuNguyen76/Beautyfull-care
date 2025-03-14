package com.beautyfullcare.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingRequest {
    @NotNull(message = "Service ID is required")
    private Long serviceId;

    private Long therapistId;

    @NotNull(message = "Booking time is required")
    @Future(message = "Booking time must be in the future")
    private LocalDateTime bookingTime;

    private String notes;
}

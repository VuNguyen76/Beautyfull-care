package com.beautyfullcare.repository;

import com.beautyfullcare.entity.Booking;
import com.beautyfullcare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCustomer(User customer);

    List<Booking> findByTherapistId(Long therapistId);
}

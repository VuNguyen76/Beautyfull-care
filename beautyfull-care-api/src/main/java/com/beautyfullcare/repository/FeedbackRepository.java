package com.beautyfullcare.repository;

import com.beautyfullcare.entity.Feedback;
import com.beautyfullcare.entity.BeautyService;
import com.beautyfullcare.entity.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByService(BeautyService service);

    List<Feedback> findByTherapist(Specialist therapist);
}

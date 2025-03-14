package com.beautyfullcare.service;

import com.beautyfullcare.entity.Feedback;
import com.beautyfullcare.entity.User;
import com.beautyfullcare.exception.ResourceNotFoundException;
import com.beautyfullcare.repository.FeedbackRepository;
import com.beautyfullcare.repository.BeautyServiceRepository;
import com.beautyfullcare.repository.SpecialistRepository;
import com.beautyfullcare.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final UserRepository userRepository;
    private final BeautyServiceRepository beautyServiceRepository;
    private final SpecialistRepository specialistRepository;

    public Feedback submitFeedback(Long customerId, Long serviceId, Long therapistId,
            Integer rating, String comment) {
        User customer = userRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        Feedback feedback = new Feedback();
        feedback.setCustomer(customer);
        feedback.setRating(rating);
        feedback.setComment(comment);

        if (serviceId != null) {
            feedback.setService(beautyServiceRepository.findById(serviceId)
                    .orElseThrow(() -> new ResourceNotFoundException("Service not found")));
        }

        if (therapistId != null) {
            feedback.setTherapist(specialistRepository.findById(therapistId)
                    .orElseThrow(() -> new ResourceNotFoundException("Therapist not found")));
        }

        return feedbackRepository.save(feedback);
    }

    public List<Feedback> getFeedbackForService(Long serviceId) {
        return feedbackRepository.findByService(beautyServiceRepository.findById(serviceId)
                .orElseThrow(() -> new ResourceNotFoundException("Service not found")));
    }

    public List<Feedback> getFeedbackForTherapist(Long therapistId) {
        return feedbackRepository.findByTherapist(specialistRepository.findById(therapistId)
                .orElseThrow(() -> new ResourceNotFoundException("Therapist not found")));
    }
}

package com.beautyfullcare.service;

import com.beautyfullcare.entity.Specialist;
import com.beautyfullcare.repository.SpecialistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecialistService {
    private final SpecialistRepository specialistRepository;

    public List<Specialist> getAllSpecialists() {
        return specialistRepository.findAll();
    }

    public Optional<Specialist> getSpecialistById(Long id) {
        return specialistRepository.findById(id);
    }

    public Specialist createSpecialist(Specialist specialist) {
        return specialistRepository.save(specialist);
    }

    public Specialist updateSpecialist(Long id, Specialist specialistDetails) {
        Specialist specialist = specialistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Specialist not found"));
        specialist.setFirstName(specialistDetails.getFirstName());
        specialist.setLastName(specialistDetails.getLastName());
        specialist.setSpecialization(specialistDetails.getSpecialization());
        specialist.setExperienceYears(specialistDetails.getExperienceYears());
        specialist.setWorkingDays(specialistDetails.getWorkingDays());
        return specialistRepository.save(specialist);
    }

    public void deleteSpecialist(Long id) {
        specialistRepository.deleteById(id);
    }
}

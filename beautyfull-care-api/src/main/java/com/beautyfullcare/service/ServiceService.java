package com.beautyfullcare.service;

import com.beautyfullcare.entity.BeautyService;
import com.beautyfullcare.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public List<BeautyService> getAllServices() {
        return serviceRepository.findAll();
    }

    public Optional<BeautyService> getServiceById(Long id) {
        return serviceRepository.findById(id);
    }

    public BeautyService createService(BeautyService beautyService) {
        return serviceRepository.save(beautyService);
    }

    public BeautyService updateService(Long id, BeautyService beautyServiceDetails) {
        BeautyService beautyService = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        beautyService.setName(beautyServiceDetails.getName());
        beautyService.setDescription(beautyServiceDetails.getDescription());
        beautyService.setPrice(beautyServiceDetails.getPrice());
        return serviceRepository.save(beautyService);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}

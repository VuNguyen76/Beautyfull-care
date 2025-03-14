package com.beautyfullcare.controller;

import com.beautyfullcare.entity.BeautyService;
import com.beautyfullcare.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServiceController {
    private final ServiceService serviceService;

    @GetMapping
    public ResponseEntity<List<BeautyService>> getAllServices() {
        return ResponseEntity.ok(serviceService.getAllServices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeautyService> getServiceById(@PathVariable Long id) {
        return serviceService.getServiceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BeautyService> createService(@RequestBody BeautyService beautyService) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(serviceService.createService(beautyService));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BeautyService> updateService(
            @PathVariable Long id,
            @RequestBody BeautyService beautyServiceDetails) {
        return ResponseEntity.ok(serviceService.updateService(id, beautyServiceDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}

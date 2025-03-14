package com.beautyfullcare.controller;

import com.beautyfullcare.entity.Specialist;
import com.beautyfullcare.service.SpecialistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specialists")
@RequiredArgsConstructor
public class SpecialistController {
    private final SpecialistService specialistService;

    @GetMapping
    public ResponseEntity<List<Specialist>> getAllSpecialists() {
        return ResponseEntity.ok(specialistService.getAllSpecialists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialist> getSpecialistById(@PathVariable Long id) {
        return specialistService.getSpecialistById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Specialist> createSpecialist(@RequestBody Specialist specialist) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(specialistService.createSpecialist(specialist));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specialist> updateSpecialist(
            @PathVariable Long id,
            @RequestBody Specialist specialistDetails) {
        return ResponseEntity.ok(specialistService.updateSpecialist(id, specialistDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialist(@PathVariable Long id) {
        specialistService.deleteSpecialist(id);
        return ResponseEntity.noContent().build();
    }
}

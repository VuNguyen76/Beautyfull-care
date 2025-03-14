package com.beautyfullcare.repository;

import com.beautyfullcare.entity.BeautyService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<BeautyService, Long> {
}

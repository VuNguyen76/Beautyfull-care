package com.beautyfullcare.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/home")
public class HomeController {

        @GetMapping
        public Map<String, Object> getHomeInfo() {
                Map<String, Object> response = new HashMap<>();

                // Center information
                Map<String, String> centerInfo = new HashMap<>();
                centerInfo.put("name", "Beautyfull Care Center");
                centerInfo.put("address", "123 Beauty Street, Saigon");
                centerInfo.put("phone", "+84 123 456 789");
                centerInfo.put("email", "info@beautyfullcare.com");
                response.put("centerInfo", centerInfo);

                // Featured services
                List<Map<String, String>> services = List.of(
                                Map.of("name", "Facial Care", "description", "Professional facial treatment"),
                                Map.of("name", "Body Care", "description", "Relaxing body massage"),
                                Map.of("name", "Skin Analysis", "description", "Advanced skin analysis"));
                response.put("services", services);

                // Featured specialists
                List<Map<String, String>> specialists = List.of(
                                Map.of("name", "Dr. Anna Nguyen", "specialization", "Dermatology"),
                                Map.of("name", "Dr. Michael Tran", "specialization", "Aesthetic Medicine"));
                response.put("specialists", specialists);

                // Latest blog posts
                List<Map<String, String>> blogPosts = List.of(
                                Map.of("title", "5 Tips for Healthy Skin", "date", "2025-03-01"),
                                Map.of("title", "The Importance of Sun Protection", "date", "2025-02-25"));
                response.put("blogPosts", blogPosts);

                return response;
        }
}

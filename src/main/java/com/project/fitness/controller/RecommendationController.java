package com.project.fitness.controller;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.model.Recommendation;
import com.project.fitness.service.RecommendationService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;
    @PostMapping("/generate")
    public ResponseEntity<Recommendation> generateRecommendation(
            @RequestBody RecommendationRequest request
    ){

        Recommendation recommendation = recommendationService.generateRecommendation(request);

        return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Recommendation>> getUserRecommendation(@PathVariable("id") String id){
        List<Recommendation> recommendationList = recommendationService.getUserRecommendation(id);
        return ResponseEntity.ok(recommendationList);

    }
    @GetMapping("/activity/{id}")
    public ResponseEntity<List<Recommendation>> getActivityRecommendation(@PathVariable("id") String id){
        List<Recommendation> recommendationList = recommendationService.getActivityRecommendataion(id);
        return ResponseEntity.ok(recommendationList);
    }
}

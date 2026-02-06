package com.project.fitness.service;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.model.Activity;
import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.RecommendationRepository;
import com.project.fitness.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@RequiredArgsConstructor
@Service
public class RecommendationService {
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final RecommendationRepository recommendationRepository;

    public Recommendation generateRecommendation(RecommendationRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(()-> new RuntimeException("User not found : "+request.getUserId()));
        Activity activity = activityRepository.findById(request.getActivityId())
                .orElseThrow(()-> new RuntimeException("Activity not found : "+request.getActivityId()));
        Recommendation recommendation = Recommendation
                .builder()
                .user(user)
                .activity(activity)
                .improvements(request.getImprovements())
                .safety(request.getSafety())
                .build();

        Recommendation savedRecommendataion = recommendationRepository.save(recommendation);
        return savedRecommendataion;
    }

    public List<Recommendation> getUserRecommendation(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("user not found of id: "+id));
        List<Recommendation>  recommendationList = recommendationRepository.findAllByUser(user);
        return recommendationList;
    }
    public List<Recommendation> getActivityRecommendataion(String id){
        Activity activity= activityRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Actinity not found of id : "+id));
        List<Recommendation> recommendationList = recommendationRepository.findAllByActivity(activity);
        return recommendationList;

    }
}

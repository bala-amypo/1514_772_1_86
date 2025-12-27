package com.example.demo.service.impl;

import com.example.demo.entity.Fertilizer;
import com.example.demo.entity.Suggestion;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {

    private final FertilizerRepository fertilizerRepository;
    private final SuggestionRepository suggestionRepository;

    @Override
    public List<Fertilizer> suggest(String cropName) {
        return fertilizerRepository.findByRecommendedForCrops(cropName);
    }

    @Override
    public Suggestion saveSuggestion(String cropName, String fertilizerName) {
        Suggestion suggestion = new Suggestion();
        suggestion.setCropName(cropName);
        suggestion.setFertilizerName(fertilizerName);
        return suggestionRepository.save(suggestion);
    }
}

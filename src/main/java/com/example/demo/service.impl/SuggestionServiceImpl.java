package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.entity.Farm;
import com.example.demo.entity.Fertilizer;
import com.example.demo.entity.Suggestion;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CropRepository;
import com.example.demo.repository.FarmRepository;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.repository.SuggestionRepository;
import com.example.demo.service.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {

    private final FarmRepository farmRepository;
    private final CropRepository cropRepository;
    private final FertilizerRepository fertilizerRepository;
    private final SuggestionRepository suggestionRepository;

    @Override
    public Suggestion generateSuggestion(Long farmId, Long userId) {

        Farm farm = farmRepository.findByIdAndOwnerId(farmId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found"));

        List<Crop> crops = cropRepository.findSuitableCrops(
                farm.getSoilPH(),
                farm.getWaterLevel(),
                farm.getSeason()
        );

        String cropNames = crops.stream()
                .map(Crop::getName)
                .collect(Collectors.joining(", "));

        List<Fertilizer> fertilizers = fertilizerRepository.findByCropName(cropNames);

        String fertilizerNames = fertilizers.stream()
                .map(Fertilizer::getName)
                .collect(Collectors.joining(", "));

        Suggestion suggestion = Suggestion.builder()
                .farm(farm)
                .suggestedCrops(cropNames)
                .suggestedFertilizers(fertilizerNames)
                .build();

        return suggestionRepository.save(suggestion);
    }
}

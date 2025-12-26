package com.example.demo.service.impl;

import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Fertilizer;
import com.example.demo.repository.FertilizerRepository;
import com.example.demo.service.FertilizerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FertilizerServiceImpl implements FertilizerService {

    private final FertilizerRepository fertilizerRepository;

    @Override
    public Fertilizer addFertilizer(FertilizerRequest request) {

        Fertilizer fertilizer = Fertilizer.builder()
                .name(request.getName())
                .npkRatio(request.getNpkRatio())
                .recommendedForCrops(request.getRecommendedForCrops())
                .build();

        return fertilizerRepository.save(fertilizer);
    }

    @Override
    public List<Fertilizer> getAllFertilizers() {
        return fertilizerRepository.findAll();
    }
}

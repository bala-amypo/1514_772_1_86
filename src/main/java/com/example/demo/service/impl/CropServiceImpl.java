package com.example.demo.service.impl;

import com.example.demo.dto.CropRequest;
import com.example.demo.entity.Crop;
import com.example.demo.repository.CropRepository;
import com.example.demo.service.CropService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CropServiceImpl implements CropService {

    private final CropRepository cropRepository;

    @Override
    public Crop addCrop(CropRequest request) {

        Crop crop = Crop.builder()
                .name(request.getName())
                .suitablePHMin(request.getSuitablePHMin())
                .suitablePHMax(request.getSuitablePHMax())
                .requiredWater(request.getRequiredWater())
                .season(request.getSeason())
                .build();

        return cropRepository.save(crop);
    }

    @Override
    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }
}

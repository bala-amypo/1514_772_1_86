package com.example.demo.service.impl;

import com.example.demo.dto.CropRequest;
import com.example.demo.entity.Crop;
import com.example.demo.repository.CropRepository;
import com.example.demo.service.CropService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CropServiceImpl implements CropService {

    private final CropRepository cropRepository;

    @Override
    public Crop create(CropRequest request) {
        Crop crop = new Crop();
        crop.setName(request.getName());
        crop.setSeason(request.getSeason());
        crop.setSoilType(request.getSoilType());
        return cropRepository.save(crop);
    }
}

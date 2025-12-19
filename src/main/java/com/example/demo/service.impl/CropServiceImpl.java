package com.example.demo.service.impl;

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
    public Crop createCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    @Override
    public Crop getCropById(Long id) {
        return cropRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Crop not found with id: " + id));
    }

    @Override
    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    @Override
    public Crop updateCrop(Long id, Crop crop) {
        Crop existing = getCropById(id);

        existing.setCropName(crop.getCropName());
        existing.setSeason(crop.getSeason());
        existing.setMinSoilPh(crop.getMinSoilPh());
        existing.setMaxSoilPh(crop.getMaxSoilPh());

        return cropRepository.save(existing);
    }

    @Override
    public void deleteCrop(Long id) {
        cropRepository.deleteById(id);
    }
}

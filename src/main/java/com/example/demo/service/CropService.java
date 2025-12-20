package com.example.demo.service;

import com.example.demo.entity.Crop;

import java.util.List;

public interface CropService {

    Crop createCrop(Crop crop);

    Crop getCropById(Long id);

    List<Crop> getAllCrops();

    Crop updateCrop(Long id, Crop crop);

    void deleteCrop(Long id);
}

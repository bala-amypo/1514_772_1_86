package com.example.demo.service;

import com.example.demo.entity.Crop;

import java.util.List;

public interface CropService {

    Crop addCrop(Crop crop);

    List<Crop> getAllCrops();

    Crop getCropById(Long id);
}                 
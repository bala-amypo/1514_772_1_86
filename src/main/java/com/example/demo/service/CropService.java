package com.example.demo.service;

import com.example.demo.dto.CropRequest;
import com.example.demo.entity.Crop;

import java.util.List;

public interface CropService {

    Crop addCrop(CropRequest request);

    List<Crop> getAllCrops();
}

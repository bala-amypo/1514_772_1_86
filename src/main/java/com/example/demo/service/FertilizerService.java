package com.example.demo.service;

import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Fertilizer;

import java.util.List;

public interface FertilizerService {

    Fertilizer addFertilizer(FertilizerRequest request);

    List<Fertilizer> getAllFertilizers();
}

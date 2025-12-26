package com.example.demo.service;

import com.example.demo.dto.FarmRequest;

public interface FarmService {

    Object createFarm(FarmRequest farmRequest, Long userId);

    Object getFarms(Long userId);
}

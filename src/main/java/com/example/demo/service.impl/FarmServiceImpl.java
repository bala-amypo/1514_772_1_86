package com.example.demo.service.impl;

import com.example.demo.dto.FarmRequest;
import com.example.demo.service.FarmService;
import org.springframework.stereotype.Service;

@Service
public class FarmServiceImpl implements FarmService {

    @Override
    public Object createFarm(FarmRequest farmRequest, Long userId) {
        return "Farm created for userId = " + userId;
    }

    @Override
    public Object getFarms(Long userId) {
        return "Farms list for userId = " + userId;
    }
}

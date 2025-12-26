package com.example.demo.service.impl;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FarmRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;
    private final UserRepository userRepository;

    @Override
    public Farm createFarm(FarmRequest request, Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Farm farm = Farm.builder()
                .name(request.getName())
                .soilPH(request.getSoilPH())
                .waterLevel(request.getWaterLevel())
                .season(request.getSeason())
                .owner(user)
                .build();

        return farmRepository.save(farm);
    }

    @Override
    public List<Farm> getFarmsByUser(Long userId) {
        return farmRepository.findByOwnerId(userId);
    }
}

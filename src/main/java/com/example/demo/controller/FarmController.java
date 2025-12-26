package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.service.FarmService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/farms")
public class FarmController {

    private final FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    // CREATE FARM
    @PostMapping
    public Object createFarm(
            @Valid @RequestBody FarmRequest farmRequest,
            HttpServletRequest request
    ) {

        // String → Long (FIX)
        Long userId = Long.parseLong(request.getHeader("userId"));

        return farmService.createFarm(userId, farmRequest);
    }

    // GET FARMS
    @GetMapping
    public Object getFarms(HttpServletRequest request) {

        // String → Long (FIX)
        Long userId = Long.parseLong(request.getHeader("userId"));

        return farmService.getFarms(userId);
    }
}

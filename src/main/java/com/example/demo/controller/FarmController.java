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

    @PostMapping
    public Object createFarm(
            @Valid @RequestBody FarmRequest farmRequest,
            HttpServletRequest request
    ) {
        Long userId = Long.parseLong(request.getHeader("userId"));
        return farmService.createFarm(farmRequest, userId);
    }

    @GetMapping
    public Object getFarms(HttpServletRequest request) {
        Long userId = Long.parseLong(request.getHeader("userId"));
        return farmService.getFarms(userId);
    }
}

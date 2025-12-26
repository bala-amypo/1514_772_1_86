package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.FarmService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farms")
@RequiredArgsConstructor
public class FarmController {

    private final FarmService farmService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping
    public Farm createFarm(
            @Valid @RequestBody FarmRequest request,
            HttpServletRequest httpRequest) {

        Long userId = jwtTokenProvider.getUserIdFromRequest(httpRequest);
        return farmService.createFarm(request, userId);
    }

    @GetMapping
    public List<Farm> getMyFarms(HttpServletRequest httpRequest) {

        Long userId = jwtTokenProvider.getUserIdFromRequest(httpRequest);
        return farmService.getFarmsByUser(userId);
    }
}

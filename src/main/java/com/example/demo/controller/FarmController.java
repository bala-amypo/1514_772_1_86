package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;
import com.example.demo.entity.User;
import com.example.demo.service.FarmService;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farms")
public class FarmController {

    private final FarmService farmService;
    private final UserService userService;

    public FarmController(FarmService farmService,
                          UserService userService) {
        this.farmService = farmService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Farm> createFarm(
            @Valid @RequestBody FarmRequest request,
            Authentication authentication) {

        String email = authentication.getName();
        User user = userService.findByEmail(email);

        Farm farm = Farm.builder()
                .name(request.getName())
                .soilPH(request.getSoilPH())
                .waterLevel(request.getWaterLevel())
                .season(request.getSeason())
                .build();

        return ResponseEntity.ok(
                farmService.createFarm(farm, user.getId())
        );
    }

    @GetMapping
    public ResponseEntity<List<Farm>> getFarms(Authentication authentication) {

        String email = authentication.getName();
        User user = userService.findByEmail(email);

        return ResponseEntity.ok(
                farmService.getFarmsByOwner(user.getId())
        );
    }

    @GetMapping("/{farmId}")
    public ResponseEntity<Farm> getFarm(@PathVariable Long farmId) {
        return ResponseEntity.ok(
                farmService.getFarmById(farmId)
        );
    }
}

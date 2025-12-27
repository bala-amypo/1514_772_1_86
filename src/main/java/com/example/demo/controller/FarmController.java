package com.example.demo.controller;

import com.example.demo.dto.FarmRequest;
import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farms")
@RequiredArgsConstructor
public class FarmController {

    private final FarmService farmService;

    @PostMapping
    public ResponseEntity<Farm> create(@Valid @RequestBody FarmRequest request) {
        Farm farm = new Farm();
        farm.setName(request.getName());
        farm.setLocation(request.getLocation());
        farm.setOwnerId(request.getOwnerId());
        return ResponseEntity.ok(farmService.create(farm));
    }

    @GetMapping("/{ownerId}")
    public ResponseEntity<List<Farm>> getByOwner(@PathVariable Long ownerId) {
        return ResponseEntity.ok(farmService.getFarmsByOwner(ownerId));
    }
}

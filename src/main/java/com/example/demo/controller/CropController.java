package com.example.demo.controller;

import com.example.demo.dto.CropRequest;
import com.example.demo.entity.Crop;
import com.example.demo.service.CropService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crops")
@RequiredArgsConstructor
public class CropController {

    private final CropService cropService;

    @PostMapping
    public Crop addCrop(@Valid @RequestBody CropRequest request) {
        return cropService.addCrop(request);
    }

    @GetMapping
    public List<Crop> getAllCrops() {
        return cropService.getAllCrops();
    }
}

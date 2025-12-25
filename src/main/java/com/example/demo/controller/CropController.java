package com.example.demo.controller;

import com.example.demo.entity.Crop;
import com.example.demo.service.CropService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crops")
@RequiredArgsConstructor
public class CropController {

    private final CropService cropService;

    @PostMapping
    public Crop save(@Valid @RequestBody Crop crop) {
        return cropService.saveCrop(crop);
    }

    @GetMapping
    public List<Crop> getAll() {
        return cropService.getAllCrops();
    }

    @GetMapping("/{id}")
    public Crop getById(@PathVariable Long id) {
        return cropService.getCropById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cropService.deleteCrop(id);
    }
}

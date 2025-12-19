package com.example.demo.controller;

import com.example.demo.entity.Crop;
import com.example.demo.service.CropService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crops")
@RequiredArgsConstructor
public class CropController {

    private final CropService cropService;

    @PostMapping
    public Crop createCrop(@RequestBody Crop crop) {
        return cropService.createCrop(crop);
    }

    @GetMapping("/{id}")
    public Crop getCropById(@PathVariable Long id) {
        return cropService.getCropById(id);
    }

    @GetMapping
    public List<Crop> getAllCrops() {
        return cropService.getAllCrops();
    }

    @PutMapping("/{id}")
    public Crop updateCrop(@PathVariable Long id, @RequestBody Crop crop) {
        return cropService.updateCrop(id, crop);
    }

    @DeleteMapping("/{id}")
    public String deleteCrop(@PathVariable Long id) {
        cropService.deleteCrop(id);
        return "Crop deleted successfully";
    }
}

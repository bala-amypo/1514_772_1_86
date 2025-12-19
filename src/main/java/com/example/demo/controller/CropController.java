package com.example.demo.controller;

import com.example.demo.entity.Crop;
import com.example.demo.service.CropService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crops")
public class CropController {

    private final CropService cropService;

    public CropController(CropService cropService) {
        this.cropService = cropService;
    }

    @PostMapping
    public Crop create(@RequestBody Crop crop) {
        return cropService.createCrop(crop);
    }

    @GetMapping("/{id}")
    public Crop getById(@PathVariable Long id) {
        return cropService.getCropById(id);
    }

    @GetMapping
    public List<Crop> getAll() {
        return cropService.getAllCrops();
    }

    @PutMapping("/{id}")
    public Crop update(@PathVariable Long id, @RequestBody Crop crop) {
        return cropService.updateCrop(id, crop);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        cropService.deleteCrop(id);
        return "Crop deleted successfully";
    }
}

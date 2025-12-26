package com.example.demo.controller;

import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.FertilizerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fertilizers")
@RequiredArgsConstructor
public class FertilizerController {

    private final FertilizerService fertilizerService;

    @PostMapping
    public Fertilizer addFertilizer(@Valid @RequestBody FertilizerRequest request) {
        return fertilizerService.addFertilizer(request);
    }

    @GetMapping
    public List<Fertilizer> getAllFertilizers() {
        return fertilizerService.getAllFertilizers();
    }
}

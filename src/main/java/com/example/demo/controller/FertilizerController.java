package com.example.demo.controller;

import com.example.demo.entity.Fertilizer;
import com.example.demo.service.FertilizerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fertilizers")
@RequiredArgsConstructor
public class FertilizerController {

    private final FertilizerService fertilizerService;

    @PostMapping
    public Fertilizer create(@Valid @RequestBody Fertilizer fertilizer) {
        return fertilizerService.addFertilizer(fertilizer);
    }

    @GetMapping
    public List<Fertilizer> getAll() {
        return fertilizerService.getAllFertilizers();
    }

    @GetMapping("/{id}")
    public Fertilizer getById(@PathVariable Long id) {
        return fertilizerService.getFertilizerById(id);
    }
}

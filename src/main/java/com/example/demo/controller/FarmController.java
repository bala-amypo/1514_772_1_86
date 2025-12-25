package com.example.demo.controller;

import com.example.demo.entity.Farm;
import com.example.demo.service.FarmService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farms")
@RequiredArgsConstructor
public class FarmController {

    private final FarmService farmService;

    @PostMapping
    public Farm create(@Valid @RequestBody Farm farm) {
        return farmService.createFarm(farm);
    }

    @GetMapping("/{id}")
    public Farm getById(@PathVariable Long id) {
        return farmService.getFarmById(id);
    }

    @GetMapping
    public List<Farm> getAll() {
        return farmService.getAllFarms();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        farmService.deleteFarm(id);
    }
}

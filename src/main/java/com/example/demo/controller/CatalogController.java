package com.example.demo.controller;

import com.example.demo.dto.CropRequest;
import com.example.demo.dto.FertilizerRequest;
import com.example.demo.entity.Crop;
import com.example.demo.entity.Fertilizer;
import com.example.demo.service.CatalogService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("/crop")
    public ResponseEntity<Crop> addCrop(
            @Valid @RequestBody CropRequest request,
            Authentication authentication) {

        if (!authentication.getAuthorities().toString().contains("ADMIN")) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        Crop crop = Crop.builder()
                .name(request.getName())
                .suitablePHMin(request.getSuitablePHMin())
                .suitablePHMax(request.getSuitablePHMax())
                .requiredWater(request.getRequiredWater())
                .season(request.getSeason())
                .build();

        return ResponseEntity.ok(
                catalogService.addCrop(crop)
        );
    }

    @PostMapping("/fertilizer")
    public ResponseEntity<Fertilizer> addFertilizer(
            @Valid @RequestBody FertilizerRequest request,
            Authentication authentication) {

        if (!authentication.getAuthorities().toString().contains("ADMIN")) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        Fertilizer fertilizer = Fertilizer.builder()
                .name(request.getName())
                .npkRatio(request.getNpkRatio())
                .recommendedForCrops(request.getRecommendedForCrops())
                .build();

        return ResponseEntity.ok(
                catalogService.addFertilizer(fertilizer)
        );
    }

    @GetMapping("/crops/suitable")
    public ResponseEntity<List<Crop>> suitableCrops(
            @RequestParam Double ph,
            @RequestParam Double water,
            @RequestParam String season) {

        return ResponseEntity.ok(
                catalogService.findSuitableCrops(ph, water, season)
        );
    }

    @GetMapping("/fertilizers/by-crop")
    public ResponseEntity<List<Fertilizer>> fertilizersByCrop(
            @RequestParam String name) {

        return ResponseEntity.ok(
                catalogService.findFertilizersForCrops(List.of(name))
        );
    }
}

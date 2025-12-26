package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class CropRequest {

    @NotBlank(message = "Crop name is required")
    private String name;

    @NotNull(message = "Minimum pH is required")
    private Double suitablePHMin;

    @NotNull(message = "Maximum pH is required")
    private Double suitablePHMax;

    @NotNull(message = "Required water is required")
    @Min(value = 0, message = "Water must be positive")
    private Double requiredWater;

    @NotBlank(message = "Season is required")
    private String season;
}

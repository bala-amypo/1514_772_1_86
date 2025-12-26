package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FertilizerRequest {

    @NotBlank(message = "Fertilizer name is required")
    private String name;

    @NotBlank(message = "NPK ratio is required")
    private String npkRatio;

    @NotBlank(message = "Recommended crops field is required")
    private String recommendedForCrops;
}

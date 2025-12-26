package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class FarmRequest {

    @NotBlank(message = "Farm name is required")
    private String name;

    @NotNull(message = "Soil pH is required")
    @Min(value = 3, message = "pH must be >= 3")
    @Max(value = 10, message = "pH must be <= 10")
    private Double soilPH;

    @NotNull(message = "Water level is required")
    @Min(value = 0, message = "Water level cannot be negative")
    private Double waterLevel;

    @NotBlank(message = "Season is required")
    private String season;
}

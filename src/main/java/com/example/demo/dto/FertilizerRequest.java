package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class FertilizerRequest {

    @NotBlank(message = "Fertilizer name is required")
    private String name;

    @Pattern(
        regexp = "^\\d+-\\d+-\\d+$",
        message = "NPK format must be N-P-K"
    )
    private String npkRatio;

    @NotBlank(message = "Recommended crops are required")
    private String recommendedForCrops;
}

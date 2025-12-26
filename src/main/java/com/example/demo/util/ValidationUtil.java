package com.example.demo.util;

import com.example.demo.exception.BadRequestException;

import java.util.Set;

public class ValidationUtil {

    private static final Set<String> VALID_SEASONS =
            Set.of("Kharif", "Rabi", "Summer");

    private ValidationUtil() {
        // Utility class – prevent object creation
    }

    public static void validateSeason(String season) {
        if (season == null || !VALID_SEASONS.contains(season)) {
            throw new BadRequestException(
                    "Invalid season. Allowed values: Kharif, Rabi, Summer"
            );
        }
    }

    public static void validatePH(Double ph) {
        if (ph == null || ph < 3 || ph > 10) {
            throw new BadRequestException(
                    "Soil pH must be between 3 and 10"
            );
        }
    }

    public static void validateWater(Double water) {
        if (water == null || water < 0) {
            throw new BadRequestException(
                    "Water level must be positive"
            );
        }
    }
}

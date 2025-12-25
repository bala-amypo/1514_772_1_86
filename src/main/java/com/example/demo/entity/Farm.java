package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "farms")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Farm name is required")
    private String farmName;

    @NotBlank(message = "Location is required")
    private String location;

    @NotNull(message = "Soil pH is required")
    private Double soilPh;

    @NotBlank(message = "Season is required")
    private String season;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

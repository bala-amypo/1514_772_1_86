package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "crops")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cropName;

    @Column(nullable = false)
    private String season;

    @Column(nullable = false)
    private Double minSoilPh;

    @Column(nullable = false)
    private Double maxSoilPh;
}

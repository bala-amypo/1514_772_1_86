package com.example.demo.service;

import com.example.demo.entity.Farm;
import java.util.List;

public interface FarmService {

    Farm create(Farm farm);

    List<Farm> getFarmsByOwner(Long ownerId);
}

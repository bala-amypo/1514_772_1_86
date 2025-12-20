package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User create(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new BadRequestException("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == null) {
            user.setRole("USER");
        }
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User not found"));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(Long id, User user) {
        User existing = getById(id);
        existing.setName(user.getName());
        existing.setRole(user.getRole());
        return userRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}






package com.example.demo.service.impl;

import com.example.demo.entity.Farm;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FarmRepository;
import com.example.demo.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;

    @Override
    public Farm createFarm(Farm farm) {
        return farmRepository.save(farm);
    }

    @Override
    public Farm getFarmById(Long id) {
        return farmRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farm not found with id " + id));
    }

    @Override
    public List<Farm> getAllFarms() {
        return farmRepository.findAll();
    }

    @Override
    public List<Farm> getFarmsByUserId(Long userId) {
        return farmRepository.findByUserId(userId);
    }

    @Override
    public Farm updateFarm(Long id, Farm farm) {
        Farm existingFarm = getFarmById(id);

        existingFarm.setFarmName(farm.getFarmName());
        existingFarm.setLocation(farm.getLocation());
        existingFarm.setSoilPh(farm.getSoilPh());
        existingFarm.setSeason(farm.getSeason());
        existingFarm.setUser(farm.getUser());

        return farmRepository.save(existingFarm);
    }

    @Override
    public void deleteFarm(Long id) {
        Farm farm = getFarmById(id);
        farmRepository.delete(farm);
    }
}





package com.example.demo.service.impl;

import com.example.demo.entity.Crop;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CropRepository;
import com.example.demo.service.CropService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CropServiceImpl implements CropService {

    private final CropRepository cropRepository;

    @Override
    public Crop saveCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    @Override
    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    @Override
    public Crop getCropById(Long id) {
        return cropRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Crop not found with id " + id));
    }

    @Override
    public void deleteCrop(Long id) {
        Crop crop = getCropById(id);
        cropRepository.delete(crop);
    }
}







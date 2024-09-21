package com.si.apirest.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.si.apirest.model.entity.Brand;
import com.si.apirest.model.repository.BrandRepository;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class BrandService {
    
    @Autowired
    private final BrandRepository brandRepository;

    public void createBrand(Brand brand) {
        brandRepository.save(brand);
    }

    public Brand updateBrand(Brand brand) {
        return brandRepository.save((brand));
    }

    public void deleteBrand(int id) {
        brandRepository.deleteById(id);
    }

    public Optional<Brand> getBrand(int id) {
        return brandRepository.findById(id);
    }

    public List<Brand> getAllBrand() {
        return brandRepository.findAll();
    }
}

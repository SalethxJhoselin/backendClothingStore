package com.si.apirest.model.controller;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.si.apirest.model.entity.Brand;
import com.si.apirest.model.exceptions.OkResponse;
import com.si.apirest.model.service.BrandService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/brand")
public class BrandController {
    
    @Autowired
    private final BrandService brandService;

     @PostMapping
    public ResponseEntity<OkResponse> crearBrand(@RequestBody @Valid Brand brand) {
        brandService.createBrand(brand);
        return ResponseEntity.ok(OkResponse.builder()
        .message("marca creada correctamente")
        .build());
    }

    @PutMapping
    public void updateBrand(@RequestBody Brand brand) {
        brandService.updateBrand(brand);
    }

    @GetMapping("/{id}")
    public Optional<Brand> getBrand(@PathVariable int id) {
        return brandService.getBrand(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBrand(@PathVariable int id) {
        brandService.deleteBrand(id);
    }

    @GetMapping
    public List<Brand> getAllBrand() {
        return brandService.getAllBrand();
    }

}

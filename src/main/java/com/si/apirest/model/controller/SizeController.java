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

import com.si.apirest.model.entity.Size;
import com.si.apirest.model.exceptions.OkResponse;
import com.si.apirest.model.service.SizeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/size")
public class SizeController {

    @Autowired
    private final SizeService sizeService;

    @PostMapping
    public ResponseEntity<OkResponse> crearSize(@RequestBody @Valid Size size) {
        sizeService.createSize(size);
        return ResponseEntity.ok(OkResponse.builder()
                .message("talla creada correctamente")
                .build());
    }

    @PutMapping
    public void updateSize(@RequestBody Size size) {
        sizeService.updateSize(size);
    }

    @GetMapping("/{id}")
    public Optional<Size> getSize(@PathVariable int id) {
        return sizeService.getSize(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSize(@PathVariable int id) {
        sizeService.deleteSize(id);
    }

    @GetMapping
    public List<Size> getAllSize() {
        return sizeService.getAllSize();
    }

}

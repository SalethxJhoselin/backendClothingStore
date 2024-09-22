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

import com.si.apirest.model.entity.Color;
import com.si.apirest.model.exceptions.OkResponse;
import com.si.apirest.model.service.ColorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/color")
public class ColorController {

    @Autowired
    private final ColorService colorService;

    @PostMapping
    public ResponseEntity<OkResponse> crearColor(@RequestBody @Valid Color color) {
        colorService.createColor(color);
        return ResponseEntity.ok(OkResponse.builder()
                .message("color creada correctamente")
                .build());
    }

    @PutMapping
    public void updateColor(@RequestBody Color color) {
        colorService.updateColor(color);
    }

    @GetMapping("/{id}")
    public Optional<Color> getColor(@PathVariable int id) {
        return colorService.getColor(id);
    }

    @DeleteMapping("/{id}")
    public void deleteColor(@PathVariable int id) {
        colorService.deleteColor(id);
    }

    @GetMapping
    public List<Color> getAllColor() {
        return colorService.getAllColor();
    }

}

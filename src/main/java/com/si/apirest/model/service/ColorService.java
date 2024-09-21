package com.si.apirest.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.si.apirest.model.entity.Color;
import com.si.apirest.model.repository.ColorRepository;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ColorService {

    @Autowired
    private final ColorRepository colorRepository;

    public void createColor(Color color) {
        colorRepository.save(color);
    }

    public Color updateColor(Color color) {
        return colorRepository.save((color));
    }

    public void deleteColor(int id) {
        colorRepository.deleteById(id);
    }

    public Optional<Color> getColor(int id) {
        return colorRepository.findById(id);
    }

    public List<Color> getAllColor() {
        return colorRepository.findAll();
    }
}

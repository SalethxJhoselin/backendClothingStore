package com.si.apirest.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.si.apirest.model.entity.Size;
import com.si.apirest.model.repository.SizeRepository;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class SizeService {
    
    @Autowired
    private final SizeRepository sizeRepository;

    public void createSize(Size size) {
        sizeRepository.save(size);
    }

    public Size updateSize(Size size) {
        return sizeRepository.save((size));
    }

    public void deleteSize(int id) {
        sizeRepository.deleteById(id);
    }

    public Optional<Size> getSize(int id) {
        return sizeRepository.findById(id);
    }

    public List<Size> getAllSize() {
        return sizeRepository.findAll();
    }
}

package com.si.apirest.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.si.apirest.model.entity.Sucursal;
import com.si.apirest.model.repository.SucursalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public void createSucursal(Sucursal sucursal) {
        sucursalRepository.save(sucursal);
    }

    public Sucursal updateSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public void deleteSucursal(int id) {
        sucursalRepository.deleteById(id);
    }

    public Optional<Sucursal> getSucursal(int id) {
        return sucursalRepository.findById(id);
    }

    public List<Sucursal> getAllSucursal() {
        return sucursalRepository.findAll();
    }
}
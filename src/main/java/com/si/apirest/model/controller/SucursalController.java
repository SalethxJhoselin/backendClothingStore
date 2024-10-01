package com.si.apirest.model.controller;

import java.util.Optional;
import java.util.List;

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

import com.si.apirest.model.entity.Sucursal;
import com.si.apirest.model.exceptions.OkResponse;
import com.si.apirest.model.service.SucursalService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @PostMapping
    public ResponseEntity<OkResponse> crearSucursal(@RequestBody @Valid Sucursal sucursal) {
        sucursalService.createSucursal(sucursal);
        return ResponseEntity.ok(OkResponse.builder()
                .message("Sucursal creada correctamente")
                .build());
    }

    @PutMapping
    public void updateSucursal(@RequestBody @Valid Sucursal sucursal) {
        sucursalService.updateSucursal(sucursal);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> getSucursal(@PathVariable int id) {
        return sucursalService.getSucursal(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteSucursal(@PathVariable int id) {
        sucursalService.deleteSucursal(id);
    }

    @GetMapping
    public List<Sucursal> getAllSucursal() {
        return sucursalService.getAllSucursal();
    }
}
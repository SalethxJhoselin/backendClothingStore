package com.si.apirest.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.si.apirest.model.dto.VentaRequest;
import com.si.apirest.model.entity.Venta;
import com.si.apirest.model.service.VentaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping
    public ResponseEntity<Venta> crearVenta(@RequestBody VentaRequest request) {
        Venta venta = ventaService.crearVenta(request.getItems(), request.getSubtotal());
        return ResponseEntity.ok(venta);
    }
}
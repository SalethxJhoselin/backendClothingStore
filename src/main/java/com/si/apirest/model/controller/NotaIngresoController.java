package com.si.apirest.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.si.apirest.model.entity.NotaIngreso;
import com.si.apirest.model.service.InventarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notaIngreso")
@RequiredArgsConstructor
public class NotaIngresoController {
    @Autowired
    private final InventarioService inventarioService;

    @PostMapping
    public ResponseEntity<NotaIngreso> crearNotaIngreso(@RequestBody NotaIngreso notaIngreso) {
        NotaIngreso notaGuardada = inventarioService.procesarNotaIngreso(notaIngreso);
        return ResponseEntity.ok(notaGuardada);
    }
}

package com.si.apirest.model.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.si.apirest.model.entity.NotaVenta;
import com.si.apirest.model.service.NotaVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notaVenta")
public class NotaVentaController {
    private final NotaVentaService notaVentaService;

    @PostMapping
    public ResponseEntity<NotaVenta> crearNotaVenta(@RequestBody NotaVenta notaVenta) {
        NotaVenta nuevaNota = notaVentaService.crearNotaVenta(notaVenta);
        return ResponseEntity.ok(nuevaNota);
    }
}

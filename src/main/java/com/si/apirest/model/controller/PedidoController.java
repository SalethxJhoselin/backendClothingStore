package com.si.apirest.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.si.apirest.model.entity.Pedido;
import com.si.apirest.model.service.PedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody @Valid Pedido pedido) {
        Pedido nuevoPedido = pedidoService.crearPedido(pedido);
        return ResponseEntity.ok(nuevoPedido);
    }

    // Métodos adicionales para obtener, actualizar y eliminar pedidos
}
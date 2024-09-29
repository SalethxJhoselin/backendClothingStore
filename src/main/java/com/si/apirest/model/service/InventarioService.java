package com.si.apirest.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.entity.Inventario;
import com.si.apirest.model.entity.Producto;
import com.si.apirest.model.repository.InventarioRepository;
import com.si.apirest.model.repository.ProductoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventarioService {

    @Autowired
    private final InventarioRepository inventarioRepository;
    @Autowired
    private ProductoRepository productoRepository;

    @Transactional
    public Inventario agregarProductos(int productoId, int cantidad) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        Inventario inventario = inventarioRepository.findByProducto(producto);

        if (inventario == null) {
            inventario = Inventario.builder()
                    .producto(producto)
                    .cantidad(cantidad)
                    .build();
        } else {
            inventario.agregarProductos(cantidad);
        }

        return inventarioRepository.save(inventario);
    }

    @Transactional
    public Inventario quitarProductos(int productoId, int cantidad) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        Inventario inventario = inventarioRepository.findByProducto(producto);
        if (inventario == null) {
            throw new IllegalArgumentException("Inventario no encontrado para el producto con ID: " + productoId);
        }
        inventario.quitarProductos(cantidad);
        return inventarioRepository.save(inventario);
    }

    public Inventario consultarInventario(int productoId) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        return inventarioRepository.findByProducto(producto);
    }
}
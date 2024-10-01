package com.si.apirest.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.entity.Inventario;
import com.si.apirest.model.entity.Producto;
import com.si.apirest.model.entity.NotaIngreso;
import com.si.apirest.model.entity.DetalleNotaIngreso;
import com.si.apirest.model.repository.InventarioRepository;
import com.si.apirest.model.repository.ProductoRepository;
import com.si.apirest.model.repository.NotaIngresoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private NotaIngresoRepository notaIngresoRepository;

    public Inventario consultarInventario(int productoId) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        return inventarioRepository.findByProducto(producto);
    }

    @Transactional
    public NotaIngreso procesarNotaIngreso(NotaIngreso notaIngreso) {
        for (DetalleNotaIngreso detalle : notaIngreso.getDetalles()) {
            Producto producto = detalle.getProducto();
            Inventario inventario = inventarioRepository.findByProducto(producto);

            // Si no existe el inventario, se crea uno nuevo
            if (inventario == null) {
                inventario = Inventario.builder()
                        .producto(producto)
                        .cantidad(detalle.getCantidad())
                        .build();
            } else {
                inventario.agregarProductos(detalle.getCantidad());
            }
            inventarioRepository.save(inventario);
        }

        return notaIngresoRepository.save(notaIngreso); // Guardar la nota de ingreso
    }
}
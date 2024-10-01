package com.si.apirest.model.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.entity.DetalleVenta;
import com.si.apirest.model.entity.Inventario;
import com.si.apirest.model.entity.NotaVenta;
import com.si.apirest.model.entity.Producto;
import com.si.apirest.model.repository.InventarioRepository;
import com.si.apirest.model.repository.NotaVentaRepository;
import com.si.apirest.model.repository.ProductoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotaVentaService {
    @Autowired
    private final NotaVentaRepository notaVentaRepository;

    @Autowired
    private final ProductoRepository productoRepository;

    @Autowired
    private final InventarioRepository inventarioRepository;

    @Transactional
    public NotaVenta crearNotaVenta(NotaVenta notaVenta) {
        BigDecimal subtotal = BigDecimal.ZERO;

        for (DetalleVenta detalle : notaVenta.getDetalles()) {
            Producto producto = productoRepository.findById(detalle.getProducto().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

            // Calcular el precio total del producto considerando descuento
            BigDecimal precioFinal = producto.getPrecio();
            if (producto.getDescuento() != null) {
                BigDecimal porcentajeDescuento = BigDecimal.valueOf(producto.getDescuento().getPorcentaje())
                        .divide(BigDecimal.valueOf(100));
                precioFinal = producto.getPrecio().subtract(producto.getPrecio().multiply(porcentajeDescuento));
            }
            BigDecimal totalDetalle = precioFinal.multiply(BigDecimal.valueOf(detalle.getCantidad()));

            detalle.setPrecioUnitario(producto.getPrecio());
            detalle.setDescuento(
                    producto.getDescuento() != null ? BigDecimal.valueOf(producto.getDescuento().getPorcentaje())
                            : BigDecimal.ZERO);
            detalle.setTotal(totalDetalle);
            detalle.setNotaVenta(notaVenta);

            // Actualizar inventario
            Inventario inventario = inventarioRepository.findByProducto(producto);
            inventario.quitarProductos(detalle.getCantidad());
            inventarioRepository.save(inventario);

            subtotal = subtotal.add(totalDetalle);
        }

        notaVenta.setSubtotal(subtotal);
        return notaVentaRepository.save(notaVenta);
    }
}

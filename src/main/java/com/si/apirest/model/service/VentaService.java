package com.si.apirest.model.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.dto.VentaItemDTO;
import com.si.apirest.model.entity.Producto;
import com.si.apirest.model.entity.Venta;
import com.si.apirest.model.entity.VentaItem;
import com.si.apirest.model.repository.ProductoRepository;
import com.si.apirest.model.repository.VentaRepository;

import jakarta.transaction.Transactional;

@Service
public class VentaService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private VentaRepository ventaRepository;

    @Transactional
    public Venta crearVenta(List<VentaItemDTO> items, BigDecimal subtotal) {
        Venta venta = new Venta();
        venta.setSubtotal(subtotal);

        if (items != null) {
            for (VentaItemDTO item : items) {
                VentaItem ventaItem = new VentaItem();
                Long idLong = item.getId(); // Supongamos que es Long
                Producto producto = productoRepository.findById(idLong.intValue()) // Convertir a Integer
                        .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
                ventaItem.setProducto(producto);
                ventaItem.setVenta(venta);
                ventaItem.setCantidad(item.getCantidad());
                ventaItem.setPrecioUnitario(item.getPrice());
                ventaItem.setDescuento(item.getDescuento());

                venta.getItems().add(ventaItem); // Agrega el item a la venta
            }
        }
        return ventaRepository.save(venta);
    }
}
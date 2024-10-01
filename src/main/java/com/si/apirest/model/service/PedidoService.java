package com.si.apirest.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;

import com.si.apirest.model.repository.NotaVentaRepository;
import com.si.apirest.model.repository.PedidoRepository;
import com.si.apirest.model.entity.Pedido;
import com.si.apirest.model.entity.DetallePedido;
import com.si.apirest.model.entity.NotaVenta;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private NotaVentaRepository notaVentaRepository;

    @Transactional
    public Pedido crearPedido(Pedido pedido) {
        BigDecimal total = BigDecimal.ZERO;
        NotaVenta notaVenta = new NotaVenta();
        for (DetallePedido detalle : pedido.getDetalles()) {
            total = total.add(detalle.getTotal());
        }
        pedido.setTotal(total);
        pedido.setNotaVenta(notaVenta); // Asigna la nota de venta al pedido

        // Guardar el pedido y la nota de venta
        pedidoRepository.save(pedido);
        notaVentaRepository.save(notaVenta);

        return pedido;
    }

    // Métodos adicionales para gestionar pedidos (actualizar, eliminar, etc.)
}
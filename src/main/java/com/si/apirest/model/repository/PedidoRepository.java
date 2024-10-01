package com.si.apirest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.si.apirest.model.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
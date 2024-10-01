package com.si.apirest.model.repository;

import com.si.apirest.model.entity.NotaVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaVentaRepository extends JpaRepository<NotaVenta, Integer> {
}
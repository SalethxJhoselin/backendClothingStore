package com.si.apirest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.si.apirest.model.entity.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

}

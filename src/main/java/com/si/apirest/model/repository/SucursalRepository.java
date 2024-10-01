package com.si.apirest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.si.apirest.model.entity.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
}
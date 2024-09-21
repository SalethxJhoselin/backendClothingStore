package com.si.apirest.model.entity;


import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cantidad;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    @JsonIgnore
    private NotaVenta notaVenta;

    
    @Column(precision = 10, scale = 2)
    private BigDecimal subtotal;
}

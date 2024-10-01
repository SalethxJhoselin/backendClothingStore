package com.si.apirest.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotaVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int usuarioId;
    private LocalDate fecha;
    private BigDecimal subtotal;

    @OneToMany(mappedBy = "notaVenta", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DetalleVenta> detalles;

    @OneToOne(mappedBy = "notaVenta", cascade = CascadeType.ALL)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "sucursal_id") // Este es el nombre de la columna en la base de datos
    private Sucursal sucursal; // Aquí se maneja la relación con Sucursal
}
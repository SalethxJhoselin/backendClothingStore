package com.si.apirest.model.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class VentaItemDTO {
    private Long id;  // ID del producto
    private String name;
    private BigDecimal  price;
    private int cantidad;
    private String descuento;

    // Getters y Setters
}

package com.si.apirest.model.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class VentaRequest {
    private List<VentaItemDTO> items;
    private BigDecimal subtotal;

    // Getters y Setters
}

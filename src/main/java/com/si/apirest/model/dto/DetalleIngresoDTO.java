package com.si.apirest.model.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class DetalleIngresoDTO {
    private int cantidad;
    private BigDecimal precio;
    private InventarioIDTO inventario;
}

package com.si.apirest.model.dto;

public interface VentaResumen {
    Long getPid();
    String getNombre();
    Integer getTotalCantidad();
    Double getTotalSubtotal();
    Double getCostoPu();
    Double getCosto();
    Double getGanancia();
}

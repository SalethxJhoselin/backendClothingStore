package com.si.apirest.model.dto;

import java.math.BigDecimal;

import com.si.apirest.model.entity.Brand;
import com.si.apirest.model.entity.Category;
import com.si.apirest.model.entity.Color;
import com.si.apirest.model.entity.Descuento;
import com.si.apirest.model.entity.Size;

import lombok.Data;

@Data
public class ProductoDTO {
    private int id;
    private String nombre;
    private BigDecimal precio;
    private String imagen;
    private Category category;
    private Color color;
    private Brand brand;
    private Size size;
    private Descuento descuento;
}

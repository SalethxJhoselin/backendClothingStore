package com.si.apirest.model.dto;

import java.math.BigDecimal;

import com.si.apirest.model.entity.Brand;
import com.si.apirest.model.entity.Category;
import com.si.apirest.model.entity.Color;
import com.si.apirest.model.entity.Descuento;
import com.si.apirest.model.entity.Size;

import lombok.Data;

@Data
public class ProductoCatalogoDTO {
    private int id;
    private String nombre;
    private String imagen;
    private BigDecimal precio;
    private Size talla;
    private Category category;
    private Color color;
    private Brand brand;
    private Descuento descuento;
    private int cantidadEnInventario;

    // Constructor
    public ProductoCatalogoDTO(int id, String nombre, String imagen, BigDecimal precio,
            Size talla, Category categoria, Color color, Brand marca, Descuento descuento,
            int cantidadEnInventario) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
        this.talla = talla;
        this.category = categoria;
        this.color = color;
        this.brand = marca;
        this.descuento = descuento;
        this.cantidadEnInventario = cantidadEnInventario;
    }
}

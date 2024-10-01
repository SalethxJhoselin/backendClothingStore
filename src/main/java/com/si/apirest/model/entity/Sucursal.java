package com.si.apirest.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Atributo nombre requerido.")
    private String nombre;

    @OneToMany(mappedBy = "sucursal") // Debe coincidir con la propiedad en NotaVenta
    @JsonIgnore // Para evitar la recursión infinita al serializar
    private List<NotaVenta> notasVentas;
}
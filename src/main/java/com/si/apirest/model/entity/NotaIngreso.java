package com.si.apirest.model.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotaIngreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String proveedor; // Nombre del proveedor

    private int sucursalId; // ID de la sucursal

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "nota_ingreso_id")
    private List<DetalleNotaIngreso> detalles; // Lista de detalles de productos ingresados
}

package com.si.apirest.model.entity;

import java.util.List;

import java.math.BigDecimal;
import jakarta.persistence.CascadeType;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Ubicación del cliente es requerida.")
    private String ubicacionCliente;

    private BigDecimal total;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<DetallePedido> detalles;

    @OneToOne
    @JoinColumn(name = "nota_venta_id", referencedColumnName = "id")
    private NotaVenta notaVenta;

    // Otros atributos como estado del pedido, fecha, etc.
}
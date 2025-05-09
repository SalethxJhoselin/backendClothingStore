package com.si.apirest.model.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.si.apirest.model.dto.ProductoCatalogoDTO;
import com.si.apirest.model.dto.ProductoDTO;
import com.si.apirest.model.entity.Inventario;
import com.si.apirest.model.entity.Producto;
import com.si.apirest.model.exceptions.OkResponse;
import com.si.apirest.model.service.ProductoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping
    public ResponseEntity<OkResponse> crearProducto(@RequestBody @Valid Producto producto) {
        productoService.crearProducto(producto);
        return ResponseEntity.ok(OkResponse.builder()
                .message("Creación del producto exitosa.")
                .build());
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable int id) {
        productoService.deleteProducto(id);
    }

    @PutMapping
    public void updateProducto(@RequestBody Producto producto) {
        productoService.updateProducto(producto);
    }

    @GetMapping("/{id}")
    public Optional<Producto> findProducto(@PathVariable int id) {
        return productoService.findProducto(id);
    }

    @GetMapping
    public List<ProductoDTO> getAllProducto() {
        return productoService.getAllProducto();
    }

    @GetMapping("/category/{id}")
    public List<Inventario> findByCategory(@PathVariable int id) {
        return productoService.findByCategory(id);
    }

    @GetMapping("/size/{id}")
    public List<Inventario> findBySize(@PathVariable int id) {
        return productoService.findBySize(id);
    }

    @GetMapping("/brand/{id}")
    public List<Inventario> findByBrand(@PathVariable int id) {
        return productoService.findByBrand(id);
    }

    @GetMapping("/color/{id}")
    public List<Inventario> findByColor(@PathVariable int id) {
        return productoService.findByColor(id);
    }

    @GetMapping("/catalogo")
    public ResponseEntity<List<ProductoCatalogoDTO>> obtenerCatalogo() {
        List<ProductoCatalogoDTO> catalogo = productoService.obtenerCatalogoConInventario();
        return ResponseEntity.ok(catalogo);
    }

}

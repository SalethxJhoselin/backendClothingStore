package com.si.apirest.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.dto.ProductoCatalogoDTO;
import com.si.apirest.model.dto.ProductoDTO;
import com.si.apirest.model.entity.Brand;
import com.si.apirest.model.entity.Category;
import com.si.apirest.model.entity.Color;
import com.si.apirest.model.entity.Inventario;
import com.si.apirest.model.entity.Producto;
import com.si.apirest.model.entity.Size;
import com.si.apirest.model.repository.BrandRepository;
import com.si.apirest.model.repository.CategoryRepository;
import com.si.apirest.model.repository.ColorRepository;
import com.si.apirest.model.repository.ProductoRepository;
import com.si.apirest.model.repository.SizeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {

    @Autowired
    private final ProductoRepository productoRepository;

    @Autowired
    private final CategoryRepository categoryRepository;
    @Autowired
    private final ColorRepository colorRepository;
    @Autowired
    private final SizeRepository sizeRepository;
    @Autowired
    private final BrandRepository brandRepository;

    @Autowired
    private final ModelMapper modelMapper;
    private final InventarioService inventarioService;

    public void crearProducto(Producto producto) {
        productoRepository.save(producto);
    }

    public Optional<Producto> findProducto(int id) {
        return productoRepository.findById(id);
    }

    public List<ProductoDTO> getAllProducto() {
        List<ProductoDTO> productoDTOs = new ArrayList<>();
        List<Producto> productos = productoRepository.findAll();
        for (Producto producto : productos) {
            productoDTOs.add(modelMapper.map(producto, ProductoDTO.class));
        }
        return productoDTOs;
    }

    public void deleteProducto(int id) {
        productoRepository.deleteById(id);
    }

    public void updateProducto(Producto producto) {
        productoRepository.save((producto));
    }

    public List<Inventario> findByCategory(int id) {
        Category category = categoryRepository.findById(id).orElse(null);
        List<Inventario> inventarios = new ArrayList<>();
        List<Producto> productos = productoRepository.findByCategory(category);
        for (Producto producto : productos) {
            inventarios.add(producto.getInventario());
        }
        return inventarios;
    }

    public List<Inventario> findByColor(int id) {
        Color color = colorRepository.findById(id).orElse(null);
        List<Inventario> inventarios = new ArrayList<>();
        List<Producto> productos = productoRepository.findByColor(color);
        for (Producto producto : productos) {
            inventarios.add(producto.getInventario());
        }
        return inventarios;
    }

    public List<Inventario> findByBrand(int id) {
        Brand brand = brandRepository.findById(id).orElse(null);
        List<Inventario> inventarios = new ArrayList<>();
        List<Producto> productos = productoRepository.findByBrand(brand);
        for (Producto producto : productos) {
            inventarios.add(producto.getInventario());
        }
        return inventarios;
    }

    public List<Inventario> findBySize(int id) {
        Size size = sizeRepository.findById(id).orElse(null);
        List<Inventario> inventarios = new ArrayList<>();
        List<Producto> productos = productoRepository.findBySize(size);
        for (Producto producto : productos) {
            inventarios.add(producto.getInventario());
        }
        return inventarios;
    }

    public List<ProductoCatalogoDTO> obtenerCatalogoConInventario() {
        List<Producto> productos = productoRepository.findAll();
        List<ProductoCatalogoDTO> catalogo = new ArrayList<>();

        for (Producto producto : productos) {
            // Verificar si el inventario no es nulo
            Inventario inventario = inventarioService.consultarInventario(producto.getId());
            int cantidadEnInventario = (inventario != null) ? inventario.getCantidad() : 0;
            ProductoCatalogoDTO dto = new ProductoCatalogoDTO(
                    producto.getId(),
                    producto.getNombre(),
                    producto.getImagen(),
                    producto.getPrecio(),
                    producto.getSize(),
                    producto.getCategory(),
                    producto.getColor(),
                    producto.getBrand(),
                    producto.getDescuento(),
                    cantidadEnInventario);
            catalogo.add(dto);
        }

        return catalogo;
    }
}

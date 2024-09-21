package com.si.apirest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.si.apirest.model.entity.Category;
import com.si.apirest.model.entity.Producto;
import java.util.List;


@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer>{
    List<Producto> findByCategory(Category category);
}

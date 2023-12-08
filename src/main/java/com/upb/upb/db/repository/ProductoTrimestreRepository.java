package com.upb.upb.db.repository;

import com.upb.upb.db.model.Producto;
import com.upb.upb.db.model.ProductoTrimestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoTrimestreRepository extends JpaRepository<ProductoTrimestre, Long> {

    List<ProductoTrimestre> searchAllByProducto(String producto);

}

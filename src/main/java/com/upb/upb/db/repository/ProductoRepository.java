package com.upb.upb.db.repository;

import com.upb.upb.db.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p.precio " +
            "FROM Producto p " +
            "WHERE p.fecha = :fecha AND " +
            "p.producto = :producto")
    double getEstadoProducto(
            @Param("producto") String producto,
            @Param("fecha") String fecha);
}

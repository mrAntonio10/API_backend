package com.upb.upb.db.repository;

import com.upb.upb.db.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {

    Optional<Inventario> findById(@Param("id") Long id);

    @Query("SELECT i from Inventario i WHERE " +
            " i.producto =:producto AND i.fecha >=:fecha")
    List<Inventario> findByProductoAndFechaGreaterThan(@Param("producto") String producto, @Param("fecha") LocalDate fecha);
}

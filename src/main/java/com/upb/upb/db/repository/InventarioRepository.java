package com.upb.upb.db.repository;

import com.upb.upb.db.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {

    Optional<Inventario> findById(@Param("id") Long id);

    @Query(" SELECT i.precio FROM Inventario i " +
            " WHERE i.fecha = :fecha AND " +
            " i.producto = :producto")
    Double findByFechaInicioAndProducto(@Param("fecha") String fecha,
                                                  @Param("producto") String producto);
}

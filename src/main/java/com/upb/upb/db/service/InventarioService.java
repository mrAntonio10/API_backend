package com.upb.upb.db.service;

import com.upb.upb.db.model.Inventario;
import com.upb.upb.dto.InventarioDto;

import java.time.LocalDate;
import java.util.List;

public interface InventarioService {

    List<InventarioDto> findByProductoAndFechaGreaterThan(String producto, LocalDate fecha);
    List<Inventario> findAll();
}

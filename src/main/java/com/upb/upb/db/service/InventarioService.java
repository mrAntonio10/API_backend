package com.upb.upb.db.service;

import com.upb.upb.db.model.Inventario;

import java.util.List;

public interface InventarioService {

    Double findByFechaInicioAndProducto(String fechaInicio, String producto);
    List<Inventario> findAll();
}

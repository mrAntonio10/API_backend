package com.upb.upb.db.service.impl;

import com.upb.upb.db.model.Inventario;
import com.upb.upb.db.repository.InventarioRepository;
import com.upb.upb.db.service.InventarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InventarioServiceImpl implements InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    public Double findByFechaInicioAndProducto(String fechaInicio, String producto) {
       return inventarioRepository.findByFechaInicioAndProducto(fechaInicio, producto);
    }

    @Override
    public List<Inventario> findAll() {
        return inventarioRepository.findAll();
    }
}

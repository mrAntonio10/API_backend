package com.upb.upb.db.service.impl;

import com.upb.upb.db.model.Inventario;
import com.upb.upb.db.repository.InventarioRepository;
import com.upb.upb.db.service.InventarioService;
import com.upb.upb.dto.InventarioDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class InventarioServiceImpl implements InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    public List<InventarioDto>findByProductoAndFechaGreaterThan(String producto, LocalDate fecha) {
        List<Inventario> inventarioResp =  inventarioRepository.findByProductoAndFechaGreaterThan(producto,fecha);
        List<InventarioDto> inventarioList = new ArrayList<>();
        for (Inventario inventario : inventarioResp) {
            InventarioDto inventarioDto = new InventarioDto();
                inventarioDto.setFecha(inventario.getFecha());
                inventarioDto.setPrecio(inventario.getPrecio());
            inventarioList.add(inventarioDto);
        }
       return inventarioList;
    }

    @Override
    public List<Inventario> findAll() {
        return inventarioRepository.findAll();
    }
}

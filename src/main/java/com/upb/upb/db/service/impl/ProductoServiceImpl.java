package com.upb.upb.db.service.impl;

import com.upb.upb.db.repository.ProductoRepository;
import com.upb.upb.db.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    @Override
    public double getEstadoProducto(String producto, String fecha) {
        return productoRepository.getEstadoProducto(producto, fecha);
    }
}

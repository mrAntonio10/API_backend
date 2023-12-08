package com.upb.upb.db.service.impl;

import com.upb.upb.db.model.Producto;
import com.upb.upb.db.model.ProductoTrimestre;
import com.upb.upb.db.repository.ProductoRepository;
import com.upb.upb.db.repository.ProductoTrimestreRepository;
import com.upb.upb.db.service.ProductoService;
import com.upb.upb.db.service.ProductoTrimestreService;
import com.upb.upb.dto.ProductoDto;
import com.upb.upb.dto.ProductoTrimestreDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductoTrimestreServiceImpl implements ProductoTrimestreService {

    @Autowired
    private ProductoTrimestreRepository productoTrimestreRepository;

    @Override
    public List<ProductoTrimestreDto> getProductosPorTrimestre(String producto) {
        return productoTrimestreRepository.searchAllByProducto(producto)
                .stream().map(ProductoTrimestreDto::new)
                .collect(Collectors.toList());
    }
}

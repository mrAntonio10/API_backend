package com.upb.upb.db.service;

import com.upb.upb.dto.ProductoTrimestreDto;

import java.util.List;

public interface ProductoTrimestreExamenService {
    List<ProductoTrimestreDto> getProductosPorTrimestre(String producto);

    String getProductoTrimestreExamen1(String producto);

    String getProductoTrimestreExamen2(String producto);

    String getProductoTrimestreExamen3(String producto);

    String getProductoTrimestreExamen4(String producto);
}

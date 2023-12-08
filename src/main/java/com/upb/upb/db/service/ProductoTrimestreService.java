package com.upb.upb.db.service;

import com.upb.upb.db.model.Producto;
import com.upb.upb.db.model.ProductoTrimestre;
import com.upb.upb.dto.ProductoDto;
import com.upb.upb.dto.ProductoTrimestreDto;

import java.util.Date;
import java.util.List;

public interface ProductoTrimestreService {

    List<ProductoTrimestreDto> getProductosPorTrimestre(String producto);


}

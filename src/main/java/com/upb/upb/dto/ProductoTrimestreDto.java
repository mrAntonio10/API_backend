package com.upb.upb.dto;

import com.upb.upb.db.model.Producto;
import com.upb.upb.db.model.ProductoTrimestre;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Getter
public class ProductoTrimestreDto {
    private int trimestre;
    private double precio;

    public ProductoTrimestreDto(ProductoTrimestre producto){
        this.trimestre = producto.getTrimestre();
        this.precio = producto.getPrecio();
    }
}

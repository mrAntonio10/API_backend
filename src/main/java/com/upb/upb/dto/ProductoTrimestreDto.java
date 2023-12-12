package com.upb.upb.dto;

import com.upb.upb.db.model.Producto;
import com.upb.upb.db.model.ProductoTrimestre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Getter
@AllArgsConstructor
public class ProductoTrimestreDto {
    private String producto;
    private int trimestre;
    private double precio;

    public ProductoTrimestreDto(ProductoTrimestre producto){
        this.producto = producto.getProducto();
        this.trimestre = producto.getTrimestre();
        this.precio = producto.getPrecio();
    }

    public ProductoTrimestreDto compareTo(ProductoTrimestreDto p) {
        if (p.precio > this.precio){
            return p;
        }
        return this;
    }
}

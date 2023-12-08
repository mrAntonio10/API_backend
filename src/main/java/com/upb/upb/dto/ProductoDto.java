package com.upb.upb.dto;

import com.upb.upb.db.model.Producto;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Getter
public class ProductoDto {
    private String producto;
    private Date fecha;
    private double precio;

    public ProductoDto(Producto producto){
        this.producto = producto.getProducto();
        this.fecha = stringToDate(producto.getFecha());
        this.precio = producto.getPrecio();
    }

    private static Date stringToDate(String dateString){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
        try {
            return dateFormat.parse(dateString);
        } catch ( Exception e) {
            log.info("conversion fallida");
            return null;
        }
    }
}

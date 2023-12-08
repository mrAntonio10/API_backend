package com.upb.upb.db.service;

import com.upb.upb.db.model.Producto;
import com.upb.upb.dto.ProductoDto;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ProductoService {

    List<String> getUniqueProducts();

    double getPrecioPorFechaExacta(String producto, String fecha);

    List<ProductoDto> getEstadosProducto(String producto, Date fecha);

    List<Producto> getAllProductos();

    void saveProduct(Producto producto);

}

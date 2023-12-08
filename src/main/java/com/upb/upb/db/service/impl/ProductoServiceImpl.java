package com.upb.upb.db.service.impl;

import com.upb.upb.db.model.Producto;
import com.upb.upb.db.repository.ProductoRepository;
import com.upb.upb.db.service.ProductoService;
import com.upb.upb.dto.ProductoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;


    @Override
    public List<String> getUniqueProducts() {
        return productoRepository.getUniqueProducts();
    }

    @Override
    public double getPrecioPorFechaExacta(String producto, String fecha) {
        return productoRepository.getEstadoProducto(producto, fecha);
    }

    @Override
    public List<ProductoDto> getEstadosProducto(String producto, Date fecha) {

        return productoRepository.findAll()
                .stream()
                .map(ProductoDto::new)
                .filter(p -> isDateAfter(fecha, p.getFecha()) && Objects.equals(p.getProducto(), producto))
                .collect(Collectors.toList());
    }

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public void saveProduct(Producto producto) {
        productoRepository.save(producto);
    }

    private static boolean isDateAfter(Date date1, Date date2) {
        log.info(date1 + " VS "+ date2);
        return date1.compareTo(date2) < 0;
    }

}

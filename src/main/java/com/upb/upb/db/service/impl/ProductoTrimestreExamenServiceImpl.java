package com.upb.upb.db.service.impl;

import com.upb.upb.db.repository.ProductoTrimestreRepository;
import com.upb.upb.db.service.ProductoTrimestreExamenService;
import com.upb.upb.dto.ProductoTrimestreDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductoTrimestreExamenServiceImpl implements ProductoTrimestreExamenService {

    private List<Map<String, Object>> getData() {
        return List.of(
                Map.of("trimestre",1,"producto","Coca Cola 2l","precio",15),
                Map.of("trimestre",2,"producto","Coca Cola 2l","precio",15),
                Map.of("trimestre",3,"producto","Coca Cola 2l","precio",14.5),
                Map.of("trimestre",4,"producto","Coca Cola 2l","precio",16.5),

                Map.of("trimestre",1,"producto","Coca Cola 1500 ml ","precio",13),
                Map.of("trimestre",2,"producto","Coca Cola 1500 ml ","precio",13.3),
                Map.of("trimestre",3,"producto","Coca Cola 1500 ml ","precio",13.5),
                Map.of("trimestre",4,"producto","Coca Cola 1500 ml ","precio",13.7),

                Map.of("trimestre",1,"producto","Coca Cola 500 ml","precio",12.3),
                Map.of("trimestre",2,"producto","Coca Cola 500 ml","precio",12.5),
                Map.of("trimestre",3,"producto","Coca Cola 500 ml","precio",12.5),
                Map.of("trimestre",4,"producto","Coca Cola 500 ml","precio",12.5)
        );
    }

    @Autowired
    private ProductoTrimestreRepository productoTrimestreRepository;

    @Override
    public List<ProductoTrimestreDto> getProductosPorTrimestre(String producto) {
        return productoTrimestreRepository.searchAllByProducto(producto)
                .stream().map(ProductoTrimestreDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getProductoTrimestreExamen1(String producto) {
        ProductoTrimestreDto trimestreDtos = productoTrimestreRepository.searchAllByProducto(producto)
                .stream().map(ProductoTrimestreDto::new)
                .min(Comparator.comparing(ProductoTrimestreDto::getPrecio)).get();

        return "Producto:\t"+trimestreDtos.getProducto()
                +"\nTrimestre:\t"+trimestreDtos.getTrimestre()
                +"\nMenorPrecio:\t"+trimestreDtos.getPrecio();
    }

    @Override
    public String getProductoTrimestreExamen2(String producto) {
        ProductoTrimestreDto trimestreDtos = productoTrimestreRepository.searchAllByProducto(producto)
                .stream().map(ProductoTrimestreDto::new)
                .max(Comparator.comparing(ProductoTrimestreDto::getPrecio)).get();

        return "Producto:\t"+trimestreDtos.getProducto()
                +"\nTrimestre:\t"+trimestreDtos.getTrimestre()
                +"\nMayorPrecio:\t"+trimestreDtos.getPrecio();
    }

    @Override
    public String getProductoTrimestreExamen3(String producto) {
        StringBuilder sb = new StringBuilder();
        productoTrimestreRepository.searchAllByProducto(producto)
                .stream().map(ProductoTrimestreDto::new)
                .forEach(x -> sb.append("[ Producto:\t").
                        append(x.getProducto()).
                        append("\tPrecio:\t").
                        append(x.getPrecio()).
                        append("],\n"));
        return sb.toString();
    }

    @Override
    public String getProductoTrimestreExamen4(String producto) {
        StringBuilder sb = new StringBuilder();
        getData().stream().map(x -> new ProductoTrimestreDto(x.get("producto").toString(),
                Integer.parseInt(x.get("trimestre").toString()),
                Double.parseDouble(x.get("precio").toString()) ))
                .filter(x -> x.getProducto().equals(producto))
                    .forEach(x -> sb.append("[ Trimestre:\t").
                    append(x.getTrimestre()).
                    append("\tPrecio:\t").
                    append(x.getPrecio()).
                    append("],\n"));
        return sb.toString();
    }
}

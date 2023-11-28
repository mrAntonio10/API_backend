package com.upb.upb.rest;


import com.upb.upb.db.model.Producto;
import com.upb.upb.db.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("/api/inventario")
@CrossOrigin(
        origins = "*",
        methods = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.DELETE,
                RequestMethod.PUT
        })
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping("/{producto}/{fecha}")
    public ResponseEntity<?> partidoFindByID(
            @PathVariable String producto,
            @PathVariable String fecha
    ){
        try{

            log .info("Solicitud del estado de un producto "  + producto+ " "+fecha);
            return ok(productoService.getEstadoProducto(producto, fecha));
        } catch (NoSuchElementException e){
            log.info("Error - producto/fecha no encontrad@ {}", e);
            HttpStatus status = HttpStatus.NOT_FOUND;
            return ResponseEntity
                    .status(status)
                    .body(null);
        } catch (Exception e){
            log.info("Error inesperado {}", e);
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return ResponseEntity
                    .status(status)
                    .body(null);
        }
    }
}

package com.upb.upb.rest;


import com.upb.upb.db.service.ProductoTrimestreExamenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("/api/inventario/examen1")
@CrossOrigin(
        origins = "*",
        methods = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.DELETE,
                RequestMethod.PUT
        })
public class ProductoControllerExamen1 {
    @Autowired
    ProductoTrimestreExamenService productoTrimestreService;



    @GetMapping("/{producto}")
    public ResponseEntity<?> getPreciosTrimestre(
            @PathVariable String producto
    ){
        try{
            log.info("examen1");
            return ok(productoTrimestreService.getProductoTrimestreExamen1(producto));
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

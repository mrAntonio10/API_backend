package com.upb.upb.rest;


import com.upb.upb.db.model.Producto;
import com.upb.upb.db.service.ProductoService;
import com.upb.upb.db.service.ProductoTrimestreExamenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("/v1/usuario")
@CrossOrigin(
        origins = "*",
        methods = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.DELETE,
                RequestMethod.PUT
        })
public class UsuarioController {

    @Autowired
    ProductoService productoService;

    @Autowired
    ProductoTrimestreExamenService productoTrimestreService;

    @GetMapping
    public ResponseEntity<List<String>> getInitialData() {
        try{
            log.info("Esta haciendo mal xd");
            return ok(productoService.getUniqueProducts());
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

    @GetMapping("/{producto}")
    public ResponseEntity<?> getPreciosTrimestre(
            @PathVariable String producto
    ){
        try{
            log.info("realizaondo busqeuda");
            return ok(productoTrimestreService.getProductosPorTrimestre(producto));
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

    @PostMapping("/agregar")
    public String insertProduct(@RequestBody Producto producto) {
        try{
            productoService.saveProduct(producto);
            return "agregacion exitosa";
        } catch (Exception e){
            return "Ha surgido un error inseperado";
        }
    }
}

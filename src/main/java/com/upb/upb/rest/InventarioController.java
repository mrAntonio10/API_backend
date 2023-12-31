package com.upb.upb.rest;

import com.upb.upb.db.service.InventarioService;
import com.upb.upb.request.InventarioRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("/api/inventarios")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class InventarioController {
    @Autowired
    InventarioService inventarioService;

    //11
    //cocacola --> send POST
    @GetMapping("")
    public ResponseEntity<?> inventarioFindAll(){
        try {
            log.info("Solicitud de todos los inventarios");
            return  ok(inventarioService.findAll());
        } catch (Exception e){
            log.info("Error inesperado {}", e);


            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Ocurrio un error con los accesos");
            responseBody.put("status", HttpStatus.NOT_FOUND.value() + " " + HttpStatus.NOT_FOUND.getReasonPhrase());

            return ResponseEntity.badRequest().body(responseBody);
        }
    }
    @PostMapping("buscarProducto")
    ResponseEntity<?> buscarProducto(@RequestBody InventarioRequest inventario) {
        try {
            log.info("Ingresando a buscar inventario con nombre " + inventario.getProducto());
            return ok(inventarioService.findByProductoAndFechaGreaterThan(inventario.getProducto(), inventario.getFecha()));
        }catch (Exception e){
            log.info("Error inesperado {}", e);


            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("mensaje", "Producto " + inventario.getProducto() + " no encontrado en la base de datos");
            responseBody.put("status", HttpStatus.NOT_FOUND.value() + " " + HttpStatus.NOT_FOUND.getReasonPhrase());

            return ResponseEntity.badRequest().body(responseBody);
        }
    }

//
//    @PostMapping("")
//    ResponseEntity<Long> guardarUsuario(@RequestBody Usuario usuarioNuevo) {
//        try {
//            return ok(usuarioService.save(usuarioNuevo));
//        }catch (Exception e){
//            log.info("Error inesperado {}", e);
//
//            Map<String, Object> responseBody = new HashMap<>();
//            responseBody.put("mensaje", "Error al guardar usuario");
//            responseBody.put("status", HttpStatus.CONFLICT.value() + " " + HttpStatus.CONFLICT.getReasonPhrase());
//            responseBody.put("catch", e);
//
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
}

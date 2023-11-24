package com.upb.upb.rest;


import com.upb.upb.db.model.Partido;
import com.upb.upb.db.service.PartidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("/api/partidos")
@CrossOrigin(
        origins = "*",
        methods = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.DELETE,
                RequestMethod.PUT
        })
public class PartidoController {
    @Autowired
    PartidoService partidoService;


    @GetMapping
    public ResponseEntity<?> partidoFindAll(){
        try{
            log .info("Solicitud de partidos");
            return ok(partidoService.findAll());
        } catch (Exception e){
            log.info("Error inesperado {}", e);
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return ResponseEntity
                    .status(status)
                    .body(error_body("Ha ocurrido un error", status));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> partidoFindByID(
            @PathVariable Long id
    ){
        try{
            log .info("Solicitud de partidos");
            return ok(partidoService.findByID(id));
        } catch (NoSuchElementException e){
            log.info("Error - partido no encontrado {}", e);
            HttpStatus status = HttpStatus.NOT_FOUND;
            return ResponseEntity
                    .status(status)
                    .body(error_body("Partido no encontrado", status));
        } catch (Exception e){
            log.info("Error inesperado {}", e);
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return ResponseEntity
                    .status(status)
                    .body(error_body("Ha ocurrido un error", status));
        }
    }
    @PostMapping
    public ResponseEntity<?> partidoSave(
            @RequestBody Partido partido
    ){
        try{
            log .info("Guardar partido");
            Long id = partidoService.save(partido);
            HttpStatus status = HttpStatus.CREATED;
            return ResponseEntity
                    .status(status)
                    .body(error_body("Partido con id("+id+") creado", status));
        } catch (DataIntegrityViolationException e){
            log.info("Error - partido ya existe {}", e);
            HttpStatus status = HttpStatus.BAD_REQUEST;
            return ResponseEntity
                    .status(status)
                    .body(error_body("Partido ya existe", status));
        } catch (Exception e){
            log.info("Error inesperado {}", e);
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return ResponseEntity
                    .status(status)
                    .body(error_body("Ha ocurrido un error", status));
        }
    }

    @PutMapping
    public ResponseEntity<?> partidoUpdate(
            @RequestBody Partido partido
    ){
        try{
            log.info("Actualizar partido");
            Long id = partidoService.update(partido);
            HttpStatus status = HttpStatus.OK;
            return ResponseEntity
                    .status(status)
                    .body(error_body("Partido con id("+id+") actualizado", status));
        } catch (NoSuchElementException e){
            log.info("Error - partido no encontrado {}", e);
            HttpStatus status = HttpStatus.NOT_FOUND;
            return ResponseEntity
                    .status(status)
                    .body(error_body("Partido no encontrado", status));
        } catch (Exception e){
            log.info("Error inesperado {}", e);
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return ResponseEntity
                    .status(status)
                    .body(error_body("Ha ocurrido un error", status));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> partidoRemove(
            @PathVariable Long id
    ){
        try{
            log .info("Guardar partido");
            id = partidoService.remove(id);
            HttpStatus status = HttpStatus.OK;
            return ResponseEntity
                    .status(status)
                    .body(error_body("Partido con id("+id+") eliminado", status));
        } catch (NoSuchElementException e){
            log.info("Error - partido no encontrado {}", e);
            HttpStatus status = HttpStatus.NOT_FOUND;
            return ResponseEntity
                    .status(status)
                    .body(error_body("Partido no encontrado", status));
        } catch (Exception e){
            log.info("Error inesperado {}", e);
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return ResponseEntity
                    .status(status)
                    .body(error_body("Ha ocurrido un error", status));
        }
    }

    private Map<String, Object> error_body(String message, HttpStatus status){
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", message);
        responseBody.put("status", status.value() + " " + status.getReasonPhrase());
        return responseBody;
    }
}

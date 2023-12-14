package com.upb.upb.rest;


import com.upb.upb.db.service.MascotaService;
import com.upb.upb.db.service.UsuarioService;
import com.upb.upb.dto.MascotaDto;
import com.upb.upb.dto.VisitaDto;
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
@RequestMapping("/v1/mascota")
@CrossOrigin(
        origins = "*",
        methods = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.DELETE,
                RequestMethod.PUT
        })
public class MascotaController {
    @Autowired
    MascotaService mascotaService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/{nombre}")
    public ResponseEntity<List<MascotaDto>> getMascotaPorNombre(
            @PathVariable String nombre
    ) {
        try{
            log.info("realizaondo busqeuda");
            return ok(mascotaService.getMascotasPorNombre(nombre));
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

    @GetMapping("/{propietario}")
    public ResponseEntity<List<MascotaDto>> getMascotaPorPropietario(
            @PathVariable String propietario
    ) {
        try{
            log.info("realizaondo busqeuda");
            return ok(usuarioService.getMascotaPorPropietario(propietario));
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

    @GetMapping("/{id}")
    public ResponseEntity<List<VisitaDto>> getHistorialVisitasMascota(
            @PathVariable String id
    ) {
        try{
            log.info("realizaondo busqeuda");
            return ok(mascotaService.getHistorialVisitasMascota(Integer.parseInt(id)));
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

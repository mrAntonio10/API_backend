package com.upb.upb.rest;


import com.upb.upb.db.model.InfoMascota;
import com.upb.upb.db.model.RegistroVisita;
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
@RequestMapping("/v1/mascotas")
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

    @GetMapping("/petName/{nombre}")
    public ResponseEntity<MascotaDto> getMascotaPorNombre(
            @PathVariable String nombre
    ) {
        try{
            log.info("busqueda de mascotas por su nombre");
            return ok(mascotaService.getMascotasPorNombre(nombre));
        } catch (NoSuchElementException e){
            log.info("Error - mascota no encontrad@ {}", e);
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

    @GetMapping("/petOwner/{propietario}")
    public ResponseEntity<List<MascotaDto>> getMascotaPorPropietario(
            @PathVariable String propietario
    ) {
        try{
            log.info("busqueda de mascotas por propietario");
            return ok(usuarioService.getMascotasPorPropietario(propietario));
        } catch (NoSuchElementException e){
            log.info("Error - no se encontro mascota con el propietario {}", e);
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

    @GetMapping("/logs/{id}")
    public ResponseEntity<List<VisitaDto>> getHistorialVisitasMascota(
            @PathVariable String id
    ) {
        try{
            log.info("historial de mascotas por ID");
            return ok(mascotaService.getHistorialVisitasMascota(Long.parseLong(id)));
        } catch (NoSuchElementException e){
            log.info("Error - no se encontro mascota con el id {}", e);
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

    @PostMapping("/")
    public ResponseEntity<InfoMascota> save(
            @RequestBody MascotaDto mascotaDto
    ) {
        try{
            log.info("agregar / modificar mascotas");
            return ok(mascotaService.save(mascotaDto));
        } catch (NoSuchElementException e){
            log.info("Error - no se pudo agregar / modificar mascota {}", e);
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

    @PostMapping("/registro/")
    public ResponseEntity<RegistroVisita> saveRegistro(
            @RequestBody VisitaDto visitaDto
    ) {
        try{
            log.info("agregar / modificar registros");
            return ok(mascotaService.saveRegistro(visitaDto));
        } catch (NoSuchElementException e){
            log.info("Error - no se pudo agregar / modificar mascota {}", e);
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

package com.upb.upb.rest;

import com.upb.upb.db.model.InfoUsuario;
import com.upb.upb.db.model.RegistroVisita;
import com.upb.upb.db.service.UsuarioService;
import com.upb.upb.dto.UsuarioDto;
import com.upb.upb.dto.VisitaDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<UsuarioDto> getInitialData(
            @RequestBody UsuarioDto usuario
    ) {
        try{
            log.info("Data recibida" + usuario.getUsername()+ " " + usuario.getPassword());
            return ok(usuarioService.verificarCredenciales(usuario));
        } catch (NoSuchElementException e){
            log.info("Error - usuario no encontrado {}", e);
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

    @GetMapping("/deleteUser/{id}")
    public ResponseEntity<UsuarioDto> eliminarUsuario(
            @PathVariable String id
    ) {
        try{
            log.info("Eliminar usuario con id: " +id);
            usuarioService.eliminarUsuario(Long.parseLong(id));
            return ok(null);
        } catch (NoSuchElementException e){
            log.info("Error - usuario no encontrado {}", e);
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
    public ResponseEntity<InfoUsuario> saveUser(
            @RequestBody UsuarioDto usuarioDto
    ) {
        try{
            log.info("agregar / modificar usuarios");
            return ok(usuarioService.save(usuarioDto));
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

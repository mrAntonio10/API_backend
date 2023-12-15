package com.upb.upb.rest;

import com.upb.upb.db.service.UsuarioService;
import com.upb.upb.dto.UsuarioDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> getInitialData(
            @RequestBody UsuarioDto usuario
    ) {
        try{
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
}

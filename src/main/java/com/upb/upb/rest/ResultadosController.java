package com.upb.upb.rest;

import com.upb.upb.db.service.ResultadosService;
import com.upb.upb.dto.ResultadosDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("/api/resultados")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ResultadosController {

    @Autowired
    ResultadosService resultadosService;

    @GetMapping("/generales")
    public ResponseEntity<List<ResultadosDto>> obtenerResultados() {
        List<ResultadosDto> resultadosDtoList = null;

        try {
            log.info("resultados");
            resultadosDtoList = resultadosService.resultadosGenerales();
            return ok(resultadosDtoList);
        } catch (Exception e) {
            log.info("Resultados no encontrados");
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/partido/{nombrePartido}")
    public ResponseEntity<ResultadosDto> resultadosPartido(
            @PathVariable String nombrePartido
            ) {
        ResultadosDto resultadosDto = null;

        try {
            log.info("Resultado");
            resultadosDto = resultadosService.resultadosPartido(nombrePartido);
            return ok(resultadosDto);
        } catch (Exception e) {
            log.info("Resultados no encontrados");
            return ResponseEntity.badRequest().body(null);
        }

    }
}

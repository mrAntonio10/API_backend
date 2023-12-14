package com.upb.upb.dto;

import com.upb.upb.db.model.RegistroVisita;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Slf4j
@Getter
public class VisitaDto {

    private int id;
    private Date fecha;
    private String tratamiento;
    private String descriptcion;
    private Date fechaRetorno;
    private String nombreVeterinaria;

    public VisitaDto(RegistroVisita visita) {
        BeanUtils.copyProperties(visita, this);
    }

}

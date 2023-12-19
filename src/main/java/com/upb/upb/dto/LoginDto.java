package com.upb.upb.dto;

import com.upb.upb.db.model.RegistroVisita;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
public class LoginDto {

    private Long id;
    private Date fecha;
    private String tratamiento;
    private String descriptcion;
    private Date fechaRetorno;
    private String nombreVeterinaria;
    private Long mascotaId;

    public LoginDto(RegistroVisita visita) {
        mascotaId = visita.getMascota().getId();
        BeanUtils.copyProperties(visita, this);
    }

}

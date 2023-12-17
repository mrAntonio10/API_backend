package com.upb.upb.dto;

import com.upb.upb.db.model.InfoMascota;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import java.util.Date;

@Slf4j
@Getter
@Setter
@AllArgsConstructor
public class MascotaDto {

    private Long id;
    private String nombre;
    private Date fechaNacimiento;
    private short sexo;
    private Long propietarioId;

    public MascotaDto(InfoMascota infoMascota) {
        propietarioId = infoMascota.getPropietario().getId();
        BeanUtils.copyProperties(infoMascota, this);
    }
}

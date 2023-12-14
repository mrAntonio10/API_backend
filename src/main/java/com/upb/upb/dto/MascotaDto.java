package com.upb.upb.dto;

import com.upb.upb.db.model.InfoMascota;
import org.springframework.beans.BeanUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import java.util.Date;

@Slf4j
@Getter
public class MascotaDto {

    private int id;
    private String nombre;
    private Date fechaNacimiento;
    private short sexo;

    public MascotaDto(InfoMascota infoMascota) {
        BeanUtils.copyProperties(infoMascota, this);
    }
}

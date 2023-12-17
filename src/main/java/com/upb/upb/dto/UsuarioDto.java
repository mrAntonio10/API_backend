package com.upb.upb.dto;

import com.upb.upb.db.model.InfoUsuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;


@Slf4j
@Getter
@Setter
@AllArgsConstructor
public class UsuarioDto {

    private Long id;
    private String username;
    private String password;
    private short tipoUsuario;
    private short estado;

    public UsuarioDto(InfoUsuario usuario) {
        BeanUtils.copyProperties(usuario, this);
    }

}

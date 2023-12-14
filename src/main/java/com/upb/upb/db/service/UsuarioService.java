package com.upb.upb.db.service;

import com.upb.upb.dto.MascotaDto;

import java.util.List;

public interface UsuarioService {

    List<MascotaDto> getMascotaPorPropietario(String nombre);

}

package com.upb.upb.db.service;

import com.upb.upb.dto.MascotaDto;
import com.upb.upb.dto.UsuarioDto;

import java.util.List;

public interface UsuarioService {

    List<MascotaDto> getMascotasPorPropietario(String nombre);

    UsuarioDto verificarCredenciales(UsuarioDto usuarioDto);

}

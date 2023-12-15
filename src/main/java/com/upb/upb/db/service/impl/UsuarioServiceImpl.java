package com.upb.upb.db.service.impl;

import com.upb.upb.db.repository.UsuarioRepository;
import com.upb.upb.db.service.UsuarioService;

import com.upb.upb.dto.MascotaDto;
import com.upb.upb.dto.UsuarioDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<MascotaDto> getMascotaPorPropietario(String nombre) {
        return null;
    }

    @Override
    public String verificarCredenciales(UsuarioDto usuarioDto) {
        return null;
    }
}

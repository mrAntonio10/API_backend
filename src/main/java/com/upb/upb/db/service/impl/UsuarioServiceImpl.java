package com.upb.upb.db.service.impl;

import com.upb.upb.db.repository.MascotaRepository;
import com.upb.upb.db.repository.UsuarioRepository;
import com.upb.upb.db.service.UsuarioService;

import com.upb.upb.dto.MascotaDto;
import com.upb.upb.dto.UsuarioDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Override
    public List<MascotaDto> getMascotasPorPropietario(String nombre) {
        Optional<List<MascotaDto>> mascotaOptional = mascotaRepository.getPetByOwnersName(nombre);
        List<MascotaDto> checked = null;
        if (mascotaOptional.isPresent()) {
            checked = mascotaOptional.get();
        }
        return checked;
    }

    @Override
    public UsuarioDto verificarCredenciales(UsuarioDto usuarioDto) {
        Optional<UsuarioDto> userChecked = usuarioRepository.getUserByCredentials(
                usuarioDto.getUsername(),
                usuarioDto.getPassword(), PageRequest.of(0, 1));
        UsuarioDto checked = null;
        if (userChecked.isPresent()) {
            checked = userChecked.get();
        }
        return checked;
    }
}

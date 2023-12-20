package com.upb.upb.db.service.impl;

import com.upb.upb.db.model.InfoMascota;
import com.upb.upb.db.model.InfoUsuario;
import com.upb.upb.db.model.RegistroVisita;
import com.upb.upb.db.repository.MascotaRepository;
import com.upb.upb.db.repository.UsuarioRepository;
import com.upb.upb.db.service.UsuarioService;

import com.upb.upb.dto.MascotaDto;
import com.upb.upb.dto.UsuarioDto;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public InfoUsuario save(UsuarioDto dto) {
        InfoUsuario usuario = new InfoUsuario();
        Optional<InfoUsuario> infoUsuario = usuarioRepository.findById(dto.getId());
        if (!infoUsuario.isPresent()) {
            throw new RuntimeException("No encontrado");
        }
        BeanUtils.copyProperties(dto, usuario);

        if (dto.getId() <= -1) {
            dto.setId(null);
            usuarioRepository.save(usuario);
        } else {
            usuarioRepository.save(usuario);
        }

        return null;
    }
}

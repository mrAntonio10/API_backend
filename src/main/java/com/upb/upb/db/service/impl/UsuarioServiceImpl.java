package com.upb.upb.db.service.impl;

import com.upb.upb.db.model.Usuario;
import com.upb.upb.db.repository.UsuarioRepository;
import com.upb.upb.db.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;



    @Override
    @Transactional
    public Long save(Usuario usuarioDto) {
        if (usuarioDto.getId() == null) {
            Usuario usuario = new Usuario();
            usuario.setId(null);
            usuario.setRol(usuarioDto.getRol());
            usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
            usuario.setPassword(usuarioDto.getPassword());
            usuario.setNombreCompleto(usuarioDto.getNombreCompleto());
            usuario.setEstado(usuarioDto.getEstado());

            usuario = usuarioRepository.save(usuario);
            return usuario.getId();
        } else {    //modificar usuario
            Optional<Usuario> usuarioOpt = usuarioRepository.findByIdAndEstadoFalse(usuarioDto.getId());
            if(!usuarioOpt.isPresent()){
                throw new NoSuchElementException("Usuario no encontrada");
            }
            Usuario usuario = usuarioOpt.get();

            usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
            usuario.setPassword(usuarioDto.getPassword());
            usuario.setNombreCompleto(usuarioDto.getNombreCompleto());
            usuario.setEstado(usuarioDto.getEstado());
            usuario.setRol(usuarioDto.getRol());

            usuario = usuarioRepository.save(usuario);
            return usuario.getId();

        }
    }

    @Override
    public Boolean findByUsernameAndPassword(String nombre, String password) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByNombreAndAndPasswordAndEstadoFalse(nombre, password);
        if(!usuarioOpt.isPresent()){
            throw new NoSuchElementException("Usuario no encontrada");
        }
        return true;
    }
}

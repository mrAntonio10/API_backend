package com.upb.upb.security;

import com.upb.upb.db.model.InfoUsuario;
import com.upb.upb.db.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Mi usuario es"+ username);

        InfoUsuario usuario2 = usuarioRepository
                .findByUsername(username).get();
        log.info(usuario2.getUsername()+ " "+ usuario2.getPassword());

        InfoUsuario usuario = usuarioRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));
        return new InfoUserDetailsImpl(usuario);
    }
}

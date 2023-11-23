package com.upb.upb.db.service;

import com.upb.upb.db.model.Usuario;

public interface UsuarioService {


    Long save(Usuario usuarioDto);

    Long findByUsernameAndPassword(String nombre, String password);
}

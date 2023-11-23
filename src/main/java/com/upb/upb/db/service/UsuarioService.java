package com.upb.upb.db.service;

import com.upb.upb.db.model.Usuario;

public interface UsuarioService {


    Long save(Usuario usuarioDto);

    Boolean findByUsernameAndPassword(String nombre, String password);
}

package com.upb.upb.db.repository;

import com.upb.upb.db.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByIdAndEstadoFalse(@Param("id") Long id);

    @Query(" SELECT u FROM Usuario u " +
            " WHERE u.estado = false AND " +
            " u.nombreUsuario = :nombreUsuario AND u.password = :password ")
    Optional<Usuario> findByNombreAndAndPasswordAndEstadoFalse(@Param("nombreUsuario") String nombreUsuario, @Param("password") String password);
}

package com.upb.upb.db.repository;

import com.upb.upb.db.model.InfoUsuario;
import com.upb.upb.dto.UsuarioDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<InfoUsuario, Long> {
    @Query("    SELECT new com.upb.upb.dto.UsuarioDto(d)" +
            "   FROM InfoUsuario d " +
            "   WHERE d.username = :username " +
            "   AND d.password = :password")
    Optional<UsuarioDto> getUserByCredentials(
            @Param("username") String username,
            @Param("password") String password,
            PageRequest pageable);
}

package com.upb.upb.db.repository;

import com.upb.upb.db.model.Votacion;
import com.upb.upb.dto.ResultadosDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VotacionRepository  extends JpaRepository<Votacion, Long> {

    @Query(" SELECT new com.upb.upb.dto.ResultadosDto(COUNT(v), v.partido.nombre) " +
            "FROM Votacion v " +
            "WHERE v.partido.nombre = :nombrePartido")
    Optional<ResultadosDto> votacionesPorPartido(@Param("nombrePartido") String nombrePartido);

    @Query(" SELECT new com.upb.upb.dto.ResultadosDto(COUNT(v), v.partido.nombre)" +
            " FROM Votacion v " +
            " GROUP BY v.partido.nombre")
    Optional<List<ResultadosDto>> resultadosGenerales();
}

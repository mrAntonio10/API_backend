package com.upb.upb.db.repository;

import com.upb.upb.db.model.RegistroVisita;
import com.upb.upb.dto.UsuarioDto;
import com.upb.upb.dto.VisitaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RegistroVisitaRepository extends JpaRepository<RegistroVisita, Long> {
    @Query("    SELECT new com.upb.upb.dto.VisitaDto(r)" +
            "   FROM RegistroVisita r " +
            "   WHERE r.mascota.nombre = :petsName ")
    Optional<List<VisitaDto>> getPetsHistoryByName(
            @Param("petsName") String petsName);

    @Query("    SELECT new com.upb.upb.dto.VisitaDto(r)" +
            "   FROM RegistroVisita r " +
            "   WHERE r.mascota.id = :petsID ")
    Optional<List<VisitaDto>> getPetsHistoryByID(
            @Param("petsID") long petsID);
}

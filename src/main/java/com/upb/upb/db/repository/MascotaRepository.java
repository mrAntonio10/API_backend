package com.upb.upb.db.repository;

import com.upb.upb.db.model.InfoMascota;
import com.upb.upb.dto.MascotaDto;
import com.upb.upb.dto.UsuarioDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MascotaRepository extends JpaRepository<InfoMascota, Long> {

    @Query("    SELECT new com.upb.upb.dto.MascotaDto(d)" +
            "   FROM InfoMascota d " +
            "   WHERE d.nombre = :nombreMascota")
    Optional<List<MascotaDto>> getPetByName(
            @Param("nombreMascota") String nombreMascota);

    @Query("    SELECT new com.upb.upb.dto.MascotaDto(d)" +
            "   FROM InfoMascota d " +
            "   WHERE d.propietario.username LIKE %:nombrePropietario%")
    Optional<List<MascotaDto>> getPetByOwnersName(
            @Param("nombrePropietario") String nombrePropietario);

}

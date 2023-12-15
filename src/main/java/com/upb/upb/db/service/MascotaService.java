package com.upb.upb.db.service;

import com.upb.upb.dto.MascotaDto;
import com.upb.upb.dto.VisitaDto;

import java.util.List;

public interface MascotaService {
    List<MascotaDto> getMascotasPorNombre(String nombre);

    List<VisitaDto> getHistorialVisitasMascota(int id);
}

package com.upb.upb.db.service;

import com.upb.upb.db.model.InfoMascota;
import com.upb.upb.db.model.RegistroVisita;
import com.upb.upb.dto.MascotaDto;
import com.upb.upb.dto.VisitaDto;

import java.util.List;

public interface MascotaService {
    MascotaDto getMascotasPorNombre(String nombre);

    List<VisitaDto> getHistorialVisitasMascota(long id);

    InfoMascota save(MascotaDto mascotaDto);

    RegistroVisita saveRegistro(VisitaDto visitaDto);
}

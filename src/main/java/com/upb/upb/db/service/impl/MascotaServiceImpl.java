package com.upb.upb.db.service.impl;

import com.upb.upb.db.model.Producto;
import com.upb.upb.db.repository.MascotaRepository;
import com.upb.upb.db.repository.ProductoRepository;
import com.upb.upb.db.service.MascotaService;
import com.upb.upb.db.service.ProductoService;
import com.upb.upb.dto.MascotaDto;
import com.upb.upb.dto.ProductoDto;
import com.upb.upb.dto.VisitaDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Override
    public List<MascotaDto> getMascotasPorNombre(String nombre) {
        return null;
    }

    @Override
    public List<VisitaDto> getHistorialVisitasMascota(int id) {
        return null;
    }
}

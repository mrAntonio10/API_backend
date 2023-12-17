package com.upb.upb.db.service.impl;

import com.upb.upb.db.model.InfoMascota;
import com.upb.upb.db.model.InfoUsuario;
import com.upb.upb.db.model.RegistroVisita;
import com.upb.upb.db.repository.MascotaRepository;
import com.upb.upb.db.repository.RegistroVisitaRepository;
import com.upb.upb.db.repository.UsuarioRepository;
import com.upb.upb.db.service.MascotaService;
import com.upb.upb.dto.MascotaDto;
import com.upb.upb.dto.VisitaDto;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private RegistroVisitaRepository registroVisitaRepository;

    @Override
    public MascotaDto getMascotasPorNombre(String nombre) {
        Optional<MascotaDto> mascotaDto = mascotaRepository.getPetByName(nombre);
        MascotaDto mascotas = null;
        if (mascotaDto.isPresent()) {
            mascotas =  mascotaDto.get();
        }
        return mascotas;
    }

    @Override
    public List<VisitaDto> getHistorialVisitasMascota(long id) {
        Optional<List<VisitaDto>> list = registroVisitaRepository.getPetsHistoryByID(id);
        List<VisitaDto> dtoList = null;
        if (list.isPresent()) {
            dtoList =  list.get();
        }
        return dtoList;
    }

    @Override
    public InfoMascota save(MascotaDto mascotaDto) {
        InfoMascota mascota = new InfoMascota();
        Optional<InfoUsuario> propietarioOpt = usuarioRepository.findById(mascotaDto.getPropietarioId());
        if (!propietarioOpt.isPresent()) {
            throw new RuntimeException("No se encontro el propietario");
        }
        BeanUtils.copyProperties(mascotaDto, mascota);

        if (mascotaDto.getId() <= -1) {

            mascotaDto.setId(null);
            mascota.setPropietario(propietarioOpt.get());
            mascota.setId(20L);
            mascotaRepository.save(mascota);

        } else {
            mascota.setPropietario(propietarioOpt.get());
            mascotaRepository.save(mascota);
        }

        return null;
    }

    @Override
    public RegistroVisita saveRegistro(VisitaDto visitaDto) {
        RegistroVisita registroVisita = new RegistroVisita();
        Optional<InfoMascota> mascotaOptional = mascotaRepository.findById(visitaDto.getMascotaId());
        if (!mascotaOptional.isPresent()) {
            throw new RuntimeException("No se encontro el propietario");
        }
        BeanUtils.copyProperties(visitaDto, registroVisita);
//
        if (visitaDto.getId() <= -1) {

            visitaDto.setId(null);
            registroVisita.setMascota(mascotaOptional.get());
            registroVisitaRepository.save(registroVisita);
//
        } else {
            log.info("Actualizado");
            registroVisita.setMascota(mascotaOptional.get());
            registroVisitaRepository.save(registroVisita);
        }
        log.info(String.valueOf(registroVisita));
        return null;
    }
}

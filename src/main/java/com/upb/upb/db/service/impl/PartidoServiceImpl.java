package com.upb.upb.db.service.impl;

import com.upb.upb.db.model.Partido;
import com.upb.upb.db.repository.PartidoRepository;
import com.upb.upb.db.service.PartidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class PartidoServiceImpl implements PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;



    @Override
    @Transactional
    public Long save(Partido partidoDto) {
        if (partidoDto.getId() != null){
            Optional<Partido> partidoOpt = partidoRepository.findById(partidoDto.getId());
            if (partidoOpt.isPresent()) {
                throw new DataIntegrityViolationException("Partido ya existe");
            }
        }
        Partido partido = new Partido();
        partido.setNombre(partidoDto.getNombre());
        partido.setImgURL(partidoDto.getImgURL());

        Partido partidoGuardado = partidoRepository.save(partido);
        return partidoGuardado.getId();

    }

    @Override
    @Transactional
    public Long update(Partido partidoDto) {
        Optional<Partido> partidoOpt = partidoRepository.findById(partidoDto.getId());
        Partido partido = partidoOpt.orElseThrow(() -> new NoSuchElementException("Partido no encontrado"));

        partido.setNombre(partidoDto.getNombre());
        partido.setImgURL(partidoDto.getImgURL());

        Partido partidoActualizado = partidoRepository.save(partido);
        return partidoActualizado.getId();
    }

    @Override
    @Transactional
    public Long remove(Long id) {
        Optional<Partido> partidoOpt = partidoRepository.findById(id);

        Partido partido = partidoOpt.orElseThrow(
                () -> new NoSuchElementException("Partido no encontrado")
        );

        partidoRepository.delete(partido);
        return partido.getId();
    }

    @Override
    public Partido findByID(Long id) {
        return partidoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Partido no encontrado con ID: " + id));
    }


    @Override
    public List<Partido> findAll() {
        return partidoRepository.findAll();
    }
}

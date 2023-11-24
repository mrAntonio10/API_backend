package com.upb.upb.db.service;

import com.upb.upb.db.model.Partido;

import java.util.List;

public interface PartidoService {


    Long save(Partido partido);
    Long update(Partido partido);
    Long remove(Long id);
    Partido findByID(Long id);
    List<Partido> findAll();


}

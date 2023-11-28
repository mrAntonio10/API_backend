package com.upb.upb.db.service.impl;

import com.upb.upb.db.model.Votacion;
import com.upb.upb.db.repository.PartidoRepository;
import com.upb.upb.db.repository.VotacionRepository;
import com.upb.upb.db.service.ResultadosService;
import com.upb.upb.dto.ResultadosDto;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResultadosServiceImp implements ResultadosService {

    private VotacionRepository votacionRepository;

    @Override
    public List<ResultadosDto> resultadosGenerales() {
        Optional<List<ResultadosDto>> resultOpt = votacionRepository.resultadosGenerales();
        if (!resultOpt.isPresent())
            throw new RuntimeException();
        return resultOpt.get();
    }

    @Override
    public ResultadosDto resultadosPartido(String nombrePartido) {
        Optional<ResultadosDto> resultOpt = votacionRepository.votacionesPorPartido(nombrePartido);
        if (!resultOpt.isPresent())
            throw new RuntimeException();
        return resultOpt.get();
    }
}

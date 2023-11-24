package com.upb.upb.db.service.impl;

import com.upb.upb.db.service.ResultadosService;
import com.upb.upb.dto.ResultadosDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultadosServiceImp implements ResultadosService {

    //private UsuarioRepository usuarioRepository;

    @Override
    public List<ResultadosDto> resultadosGenerales() {
        List<ResultadosDto> resultadosDtoList = new ArrayList<>();
        resultadosDtoList.add(new ResultadosDto(100, 0.5f));
        resultadosDtoList.add(new ResultadosDto(100, 0.5f));
        return resultadosDtoList;
    }

    @Override
    public ResultadosDto resultadosPartido(String nombrePartido) {
        return new ResultadosDto(100, 0.5f);
    }
}

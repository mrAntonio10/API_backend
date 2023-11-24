package com.upb.upb.db.service;

import com.upb.upb.dto.ResultadosDto;

import java.util.List;

public interface ResultadosService {

    List<ResultadosDto> resultadosGenerales();

    ResultadosDto resultadosPartido(String nombrePartido);

}

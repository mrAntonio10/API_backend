package com.upb.upb.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private Long id;
    private String nombreUsuario;
    private String nombreCompleto;
    private Boolean estado;
}

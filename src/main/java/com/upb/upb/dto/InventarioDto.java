package com.upb.upb.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InventarioDto {
    private LocalDate fecha;
    private Double precio;
}



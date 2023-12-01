package com.upb.upb.request;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InventarioRequest {
    private LocalDate fecha;
    private String producto;
}



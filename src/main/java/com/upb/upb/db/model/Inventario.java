package com.upb.upb.db.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "INVENTARIO")
public class Inventario implements Serializable {
    @Id
    @SequenceGenerator(name = "SEQ_INVENTARIO_ID_GENERATOR", sequenceName = "SEQ_INVENTARIO_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INVENTARIO_ID_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Column(name = "PRODUCTO")
    private String producto;

    @Column(name = "PRECIO")
    private Double precio;

}

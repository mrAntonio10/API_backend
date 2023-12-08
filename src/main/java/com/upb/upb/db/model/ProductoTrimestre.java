package com.upb.upb.db.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTO_TRIMESTRE")
public class ProductoTrimestre implements Serializable {
    @Id
    @SequenceGenerator(name = "SEQ_PRODUCT_TRIMESTRE_ID_GENERATOR", sequenceName = "SEQ_PRODUCT_TRIMESTRE_ID", allocationSize = 1, initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCT_TRIMESTRE_ID_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "TRIMESTRE")
    private int trimestre;

    @Column(name = "PRODUCTO")
    private String producto;

    @Column(name = "PRECIO")
    private double precio;

}
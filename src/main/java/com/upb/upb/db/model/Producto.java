package com.upb.upb.db.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Productos")
public class Producto implements Serializable {
    @Id
    @SequenceGenerator(name = "SEQ_PRODUCT_ID_GENERATOR", sequenceName = "SEQ_PRODUCT_ID", allocationSize = 1, initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCT_ID_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "FECHA")
    private String fecha;

    @Column(name = "PRODUCTO")
    private String producto;

    @Column(name = "PRECIO")
    private double precio;

}
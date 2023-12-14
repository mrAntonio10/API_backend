package com.upb.upb.db.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "REGISTRO")
public class RegistroVisita implements Serializable {

    @Id
    @SequenceGenerator(name = "SEQ_REGISTER_ID_GENERATOR", sequenceName = "SEQ_REGISTER_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REGISTER_ID_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pet", nullable = false)
    private InfoMascota mascota;

    @Column(name = "DATE")
    private Date fecha;

    @Column(name = "TREATMENT")
    private String tratamiento;

    @Column(name = "DESCRIPTION")
    private String descriptcion;

    @Column(name = "RETURNDATE")
    private Date fechaRetorno;

    @Column(name = "VETNAME")
    private String nombreVeterinaria;


}
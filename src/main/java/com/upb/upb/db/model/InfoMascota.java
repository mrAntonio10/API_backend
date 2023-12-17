package com.upb.upb.db.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PETS")
public class InfoMascota implements Serializable {

    @Id
    @SequenceGenerator(name = "SEQ_PET_ID_GENERATOR", sequenceName = "SEQ_PET_ID", allocationSize = 1, initialValue = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PET_ID_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String nombre;

    @Column(name = "BIRTHDATE")
    private Date fechaNacimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER", referencedColumnName = "id")
    private InfoUsuario propietario;

    @Column(name = "SEX")
    private short sexo;

}
package com.upb.upb.db.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "PARTIDO")
public class Partido implements Serializable {
    @Id
    @SequenceGenerator(
            name = "SEQ_PARTIDO_ID_GENERATOR",
            sequenceName = "SEQ_PARTIDO_ID",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_PARTIDO_ID_GENERATOR"
    )
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "IMG_URL")
    private String imgURL;

}
package com.upb.upb.db.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VOTACION")
public class Votacion implements Serializable {

    @Id
    @Column(name = "id")
    @SequenceGenerator(
            name = "SEQ_VOTACION_ID_GENERATOR",
            sequenceName = "SEQ_VOTACION_ID",
            allocationSize = 1
    )
    private Long id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "partido_id", nullable = false)
    private Partido partido;

}

package com.upb.upb.db.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {
    @Id
    @SequenceGenerator(name = "SEQ_USUARIO_ID_GENERATOR", sequenceName = "SEQ_USUARIO_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO_ID_GENERATOR")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NOMBRE_COMPLETO")
    private String nombreCompleto;

    @Column(name = "ROL")
    private Long rol;

    @Column(name = "ESTADO")
    private Boolean estado;

}
    /*

             Registro	-->/usuario	post
                nombre
                apellido
                usuario
                password

            Login --> /usuario get
                usuario -->
                password
            {return id}


            Votacion que son LOS personajes XD	-->	/partidos
                    id
                    partidopolitico
                    imgUrl

                option select <id> valor

                    { usuario.id, idPartidos}

                modulos modificables de usuarios::::

nota:: api para mostrar los partidos politicos
        api para votacion
        **api de resultados ::::count()
     */
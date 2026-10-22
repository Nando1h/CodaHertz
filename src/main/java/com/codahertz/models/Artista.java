package com.codahertz.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "artistas")
@Getter
@Setter
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "pais_origen")
    private String paisOrigen;

    @Column(length = 1000)
    private String biografia;
}

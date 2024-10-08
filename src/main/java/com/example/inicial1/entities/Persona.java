package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "persona")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
@Audited
public class Persona extends Base {

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "dni")
    private int dni;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "persona_id")
    @Builder.Default
    private Set<Libro> libros = new HashSet<>();

    /*
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
                name = "persona_libro,
                joinColumns = @JoinColumn(name = "persona_id"),
                inverseJoinColumns = @JoinColumn(name = "libro_id")
    )
    @Builder.Default
    private Set<Libro> libros = new HashSet<Libro>();

     */
}


package com.example.inicial1.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "libro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
@Audited
public class Libro extends Base {

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "fecha")
    private int fecha;

    @Column(name = "genero")
    private String genero;

    @Column(name = "paginas")
    private int paginas;

    @Column(name = "autor")
    private String autor;

    /*
    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_autor")
    @Builder.Default
    private HashSet<Autor> autores = new HashSet<>();

     */
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "articulo_categoria",
                joinColumns = @JoinColumn(name = "articulo_id"),
                inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    @Builder.Default
    private Set<Autor> autores = new HashSet<>();
}

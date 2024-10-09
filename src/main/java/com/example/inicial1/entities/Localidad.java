package com.example.inicial1.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import jakarta.persistence.*;

@Entity
@Table(name = "localidad")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
@Audited
public class Localidad extends Base {

    @Column(name = "denominacion")
    private String denominacion;
}

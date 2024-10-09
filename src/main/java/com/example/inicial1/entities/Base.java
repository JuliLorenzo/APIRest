package com.example.inicial1.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
public class Base implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

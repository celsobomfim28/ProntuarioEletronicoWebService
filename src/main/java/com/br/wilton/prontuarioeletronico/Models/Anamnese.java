package com.br.wilton.prontuarioeletronico.Models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Anamnese implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String queixa;
    private String inicio;
    private String duracao;
    private String frequencia;
    private String sintomas;
    private String motivo;
    private LocalDate data;
    @ManyToOne
    @JoinColumn(name = "prontuario.id")
    private Prontuario prontuario;
}

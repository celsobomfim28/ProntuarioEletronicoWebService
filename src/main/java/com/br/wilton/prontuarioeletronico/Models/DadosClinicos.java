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
public class DadosClinicos implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private LocalDate data_atendimento;
    private double peso;
    private double altura;
    private String pressao_arterial;
    private String glicemia;
    private String cadastrado_por;
    @ManyToOne
    @JoinColumn(name = "prontuario.id")
    private Prontuario prontuario;

}

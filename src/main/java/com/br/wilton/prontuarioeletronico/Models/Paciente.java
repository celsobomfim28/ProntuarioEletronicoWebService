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
public class Paciente implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private LocalDate data_nasciemnto;
    private String cns;
    private String telefone;
    private String rg;
    private String cpf;
    private String nome_mae;
    private String nome_pae;
    private String nacionalidade;
    private String raca;
    private String escolaridade;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @OneToOne(cascade = CascadeType.ALL)
    private Prontuario prontuario;
    @OneToOne(cascade = CascadeType.ALL)
    private InformacaoClinica informacaoClinica;

}

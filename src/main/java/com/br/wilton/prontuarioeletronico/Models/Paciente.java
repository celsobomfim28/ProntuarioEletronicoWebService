package com.br.wilton.prontuarioeletronico.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty
    private String nome;
    @NotEmpty
    private String cns;
    private String email;
    @NonNull
    private LocalDate dataNascimento;
    private String sexo;
    private String genero;
    private String telefone_celular;
    private String telefone_fixo;
    private String outro_telefone;
    private String cpf;
    private boolean sem_cpf;
    private String rg;
    private String emissor_rg;
    private String estado_civil;
    private boolean estrangeiro;
    private String passaporte;
    private String nome_mae;
    private String nome_pae;
    private String profissao;
    private double peso;
    private double altura;
    private String tipo_sanguineo;
    private String raca;
    private String nacionalidade;
    private boolean hipertenso;
    private boolean diabetico;
    private boolean gestante;
    private String observacoes_gerais;
    private String observacoes_clinicas;
    private String alergias;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @OneToOne(cascade = CascadeType.ALL)
    private Prontuario prontuario;


}

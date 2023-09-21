package com.br.wilton.prontuarioeletronico.Models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Prontuario implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String numero;
    @OneToMany(mappedBy="prontuario")
    private List<DadosClinicos> dadosClinicos;
    @OneToMany(mappedBy = "prontuario")
    private List<Medicamento> preescricao;
    @OneToMany(mappedBy = "prontuario")
    private List<Anamnese> anamnese;
    private String consultado_por;

    public Prontuario(){
        dadosClinicos = new ArrayList<>();
        preescricao = new ArrayList<>();
        anamnese = new ArrayList<>();
    }

}

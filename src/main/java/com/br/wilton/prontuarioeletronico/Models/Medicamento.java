package com.br.wilton.prontuarioeletronico.Models;

import com.br.wilton.prontuarioeletronico.Models.Enum.EmbalagemMedicamento;
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
public class Medicamento implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private int quantidade;
    private EmbalagemMedicamento tipo;
    private String uso;
    private LocalDate data_preescricao;
    @ManyToOne
    @JoinColumn(name = "prontuario.id")
    private Prontuario prontuario;
}

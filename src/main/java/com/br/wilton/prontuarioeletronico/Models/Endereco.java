package com.br.wilton.prontuarioeletronico.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String endereco;
    private int numero;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
}

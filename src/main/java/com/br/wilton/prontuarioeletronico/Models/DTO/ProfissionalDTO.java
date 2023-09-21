package com.br.wilton.prontuarioeletronico.Models.DTO;

import com.br.wilton.prontuarioeletronico.Models.Endereco;

public record ProfissionalDTO(String nome, String telefone, String cns, String cpf, String rg,
                              char sexo, String conselho, String data_nascimento, Endereco endereco, String senha, String area,
                              String role) {
}

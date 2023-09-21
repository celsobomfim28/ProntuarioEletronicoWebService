package com.br.wilton.prontuarioeletronico.Models.DTO;

import com.br.wilton.prontuarioeletronico.Models.Profissionais_de_saude;
import com.br.wilton.prontuarioeletronico.Util;

import java.time.LocalDate;

public class UtilDTO {

    public static Profissionais_de_saude toProfissional(ProfissionalDTO dto){
        Profissionais_de_saude p = new Profissionais_de_saude();
        p.setCns(dto.cns());
        p.setCpf(dto.cpf());
        p.setRg(dto.rg());
        p.setNome(dto.nome());
        p.setArea(dto.area());
        p.setConselho(dto.conselho());
        p.setCreateAt(LocalDate.now());
        p.setData_nascimento(Util.toLocalDate(dto.data_nascimento()));
        p.setTelefone(dto.telefone());
        p.setSexo(dto.sexo());
        p.setEndereco(dto.endereco());
        return p;
    }
}

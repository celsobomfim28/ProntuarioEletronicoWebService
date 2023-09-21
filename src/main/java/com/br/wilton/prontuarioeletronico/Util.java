package com.br.wilton.prontuarioeletronico;

import com.br.wilton.prontuarioeletronico.Models.DTO.ProfissionalDTO;
import com.br.wilton.prontuarioeletronico.Models.Profissionais_de_saude;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
    public static LocalDate toLocalDate(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate localDate = LocalDate.parse(data, formatter);
        return localDate;
    }

    public static String toString(LocalDate data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String formattedString = data.format(formatter);
        return formattedString;
    }

    public static String getDataHoraAtual() {
        return LocalDateTime.now().toString();
    }

    public static Profissionais_de_saude updateProfissional(Profissionais_de_saude profissionaisDeSaude, Profissionais_de_saude p) {
        p.setSexo(profissionaisDeSaude.getSexo());
        p.setEndereco(profissionaisDeSaude.getEndereco());
        p.setRg(profissionaisDeSaude.getRg());
        p.setNome(profissionaisDeSaude.getNome());
        p.setArea(profissionaisDeSaude.getArea());
        p.setTelefone(profissionaisDeSaude.getTelefone());
        p.setCpf(profissionaisDeSaude.getCpf());
        p.setCns(profissionaisDeSaude.getCns());
        p.setConselho(profissionaisDeSaude.getConselho());
        p.setData_nascimento(profissionaisDeSaude.getData_nascimento());
        p.setCreateAt(LocalDate.now());
        p.setTipo(profissionaisDeSaude.getTipo());
        p.setAtivo(profissionaisDeSaude.isAtivo());
        p.setEmail(profissionaisDeSaude.getEmail());
        p.setSenha(profissionaisDeSaude.getSenha());

        return p;

    }
}

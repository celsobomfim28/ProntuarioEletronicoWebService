package com.br.wilton.prontuarioeletronico.Service;

import com.br.wilton.prontuarioeletronico.Models.Profissionais_de_saude;
import com.br.wilton.prontuarioeletronico.Models.Usuario;
import com.br.wilton.prontuarioeletronico.Repositorio.Usuariorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProfissionalService {

    @Autowired
    Usuariorepository repository;

    public Profissionais_de_saude save(Profissionais_de_saude profissional){
        return repository.save(profissional);
    }

    public List<Usuario> index(){
        return repository.findAll();
    }

    public Profissionais_de_saude update(Profissionais_de_saude profissional){
        return repository.save(profissional);
    }

    public void remove(Profissionais_de_saude profissional){
        repository.delete(profissional);
    }
}

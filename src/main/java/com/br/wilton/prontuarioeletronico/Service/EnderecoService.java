package com.br.wilton.prontuarioeletronico.Service;

import com.br.wilton.prontuarioeletronico.Models.Endereco;
import com.br.wilton.prontuarioeletronico.Repositorio.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository repository;

    public Endereco save(Endereco endereco){
        return repository.save(endereco);
    }

    public List<Endereco> index(){
        return repository.findAll();
    }

    public Endereco update(Endereco endereco){
        return repository.save(endereco);
    }
}

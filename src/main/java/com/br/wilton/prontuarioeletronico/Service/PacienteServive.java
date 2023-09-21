package com.br.wilton.prontuarioeletronico.Service;

import com.br.wilton.prontuarioeletronico.Models.Paciente;
import com.br.wilton.prontuarioeletronico.Repositorio.PacienteRepository;
import com.br.wilton.prontuarioeletronico.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServive {
    @Autowired
    PacienteRepository repository;

    public Paciente save(Paciente paciente){
        return repository.save(paciente);
    }
    public List<Paciente> index(){
        return repository.findAll();
    }

    public void remove(String id){
        repository.deleteById(id);
    }
    public Paciente indexById(String id){
        return repository.findById(id).get();
    }
    public Paciente indexByCns(String cns){
        return repository.findByCns(cns);
    }
    public Paciente indexByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
    public List<Paciente> indexByNome(String nome){
        return repository.findByNome(nome);
    }
    public List<Paciente> indexByDataNascimento(String data){
        return repository.findByDataNascimento(Util.toLocalDate(data));
    }

}

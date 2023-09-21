package com.br.wilton.prontuarioeletronico.Repositorio;

import com.br.wilton.prontuarioeletronico.Models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, String> {

    Paciente findByCns(String cns);
    Optional<Paciente> findById(String id);
    Paciente findByCpf(String cpf);
    List<Paciente> findByNome(String nome);
    List<Paciente> findByDataNascimento(LocalDate data);

    void deleteById(String id);

}

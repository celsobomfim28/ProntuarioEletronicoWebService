package com.br.wilton.prontuarioeletronico.Repositorio;

import com.br.wilton.prontuarioeletronico.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Usuariorepository extends JpaRepository<Usuario, String> {
    Usuario findByCpf(String cpf);


}
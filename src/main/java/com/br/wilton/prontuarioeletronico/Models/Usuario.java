package com.br.wilton.prontuarioeletronico.Models;

import com.br.wilton.prontuarioeletronico.Models.Enum.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails, Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotEmpty
    private String nome;
    private String cns;
    private String email;
    @NonNull
    private LocalDate data_nascimento;
    private String telefone;
    @NotEmpty
    private String cpf;
    private LocalDate createAt;
    private String rg;
    private char sexo;
    private boolean ativo = true;
    @NotEmpty
    private String senha;
    @NonNull
    private UserRole role;
    @NonNull
    @OneToOne(cascade=CascadeType.ALL)
    private Endereco endereco;

    public Usuario(String cpf, String senha, UserRole role){
        this.cpf = cpf;
        this.senha = senha;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
                new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return cpf;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isAtivo();
    }
}

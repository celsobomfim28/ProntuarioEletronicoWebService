package com.br.wilton.prontuarioeletronico.Controles;

import com.br.wilton.prontuarioeletronico.Models.DTO.AuthenticationDTO;
import com.br.wilton.prontuarioeletronico.Models.DTO.LoginResponseDTO;
import com.br.wilton.prontuarioeletronico.Models.DTO.RegisterDTO;
import com.br.wilton.prontuarioeletronico.Models.Profissionais_de_saude;
import com.br.wilton.prontuarioeletronico.Models.Usuario;
import com.br.wilton.prontuarioeletronico.Repositorio.Usuariorepository;
import com.br.wilton.prontuarioeletronico.Service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private Usuariorepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken(auth);
        Usuario p = this.repository.findByCpf(data.login());

        return ResponseEntity.ok(new LoginResponseDTO(p.getId(),p.getNome(),token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByCpf(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Usuario newUser = new Usuario(data.login(), encryptedPassword, data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
package com.br.wilton.prontuarioeletronico.Controles;

import com.br.wilton.prontuarioeletronico.Models.DTO.ProfissionalDTO;
import com.br.wilton.prontuarioeletronico.Models.DTO.UtilDTO;
import com.br.wilton.prontuarioeletronico.Models.Endereco;
import com.br.wilton.prontuarioeletronico.Models.Profissionais_de_saude;
import com.br.wilton.prontuarioeletronico.Service.EnderecoService;
import com.br.wilton.prontuarioeletronico.Service.ProfissionalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("profissional")
public class ProfissionalController {
    @Autowired
    ProfissionalService service;
    @Autowired
    EnderecoService endereco_service;

    @PostMapping("/save")
    public ResponseEntity salvar(@RequestBody @Valid ProfissionalDTO profissionalDTO){
        try {
            Endereco e = endereco_service.save(profissionalDTO.endereco());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Profissionais_de_saude p = service.save(UtilDTO.toProfissional(profissionalDTO));

        return ResponseEntity.ok(p);
    }

    @GetMapping("/index")
    public ResponseEntity index(){
        return ResponseEntity.ok(service.index());
    }

}

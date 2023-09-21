package com.br.wilton.prontuarioeletronico.Controles;

import com.br.wilton.prontuarioeletronico.Models.DTO.ProfissionalDTO;
import com.br.wilton.prontuarioeletronico.Models.DTO.UtilDTO;
import com.br.wilton.prontuarioeletronico.Models.Profissionais_de_saude;
import com.br.wilton.prontuarioeletronico.Service.EnderecoService;
import com.br.wilton.prontuarioeletronico.Service.ProfissionalService;
import jakarta.validation.Valid;
import com.br.wilton.prontuarioeletronico.Util;
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
            endereco_service.save(profissionalDTO.endereco());
            var p = service.save(UtilDTO.toProfissional(profissionalDTO));
            return ResponseEntity.ok(p);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity update(@RequestBody @Valid Profissionais_de_saude profissionaisDeSaude,
                                 @PathVariable String id){
        try {
            var p = service.findById(id);
            var profissional = service.save(Util.updateProfissional(profissionaisDeSaude, p));
            return ResponseEntity.ok(profissional);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/index")
    public ResponseEntity index(){
        return ResponseEntity.ok(service.index());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id){
        try{
            var p = service.findById(id);
            service.remove(p);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

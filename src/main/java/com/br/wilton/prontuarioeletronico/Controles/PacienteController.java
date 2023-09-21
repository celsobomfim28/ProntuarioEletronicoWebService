package com.br.wilton.prontuarioeletronico.Controles;

import com.br.wilton.prontuarioeletronico.Models.Paciente;
import com.br.wilton.prontuarioeletronico.Service.PacienteServive;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    PacienteServive service;

    @PostMapping("/save")
    public ResponseEntity salvar(@RequestBody @Valid Paciente paciente){
        try {
            var p = service.save(paciente);
            return ResponseEntity.ok(p);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/index")
    public ResponseEntity index(){
        return ResponseEntity.ok(service.index());
    }

    @PostMapping("/indexId/{id}")
    public ResponseEntity indexById(@PathVariable String id){
        return ResponseEntity.ok(service.indexById(id));
    }
    @PostMapping("/indexCpf/{cpf}")
    public ResponseEntity indexByCpf(@RequestBody @Valid String cpf){
        return ResponseEntity.ok(service.indexByCpf(cpf));
    }
    @PostMapping("/indexCns/{cns}")
    public ResponseEntity indexByCns(@RequestBody @Valid String cns){
        return ResponseEntity.ok(service.indexByCns(cns));
    }
    @PostMapping("/indexNome/{nome}")
    public ResponseEntity indexByNome(@RequestBody @Valid String nome){
        return ResponseEntity.ok(service.indexByNome(nome));
    }
    @PostMapping("/indexData")
    public ResponseEntity indexByData(@RequestBody @Valid String data){
        return ResponseEntity.ok(service.indexByDataNascimento(data));
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity remove(@PathVariable String id){
        service.remove(id);
        return ResponseEntity.ok().build();
    }


}

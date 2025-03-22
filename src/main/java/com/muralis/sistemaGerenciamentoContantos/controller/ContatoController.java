package com.muralis.sistemaGerenciamentoContantos.controller;

import com.muralis.sistemaGerenciamentoContantos.dto.ContatoDto;
import com.muralis.sistemaGerenciamentoContantos.dto.ContatoResponseDto;
import com.muralis.sistemaGerenciamentoContantos.service.ContatoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContatoController {
    private final ContatoService contatoService;

    @PostMapping("/clientes/{id}/contatos/save")
    public ResponseEntity<?> saveContato(@PathVariable Long id, @RequestBody @Valid ContatoDto dto,
            BindingResult result) {
        ResponseEntity<?> errors = validateErrors(result);
        if (errors != null) {
            return errors;
        }
        ContatoResponseDto responseDto = contatoService.save(id, dto);
        URI uri = URI.create("/cliente/" + id + "/contatos");
        return ResponseEntity.created(uri).body(responseDto);
    }

    @GetMapping("/clientes/{id}/contatos")
    public ResponseEntity<List<ContatoResponseDto>> getContatos(@PathVariable Long id) {
        List<ContatoResponseDto> contatos = contatoService.getContatos(id);
        return ResponseEntity.ok(contatos);
    }

    @PutMapping("/contatos/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid ContatoDto dto, BindingResult result) {
        ResponseEntity<?> errors = validateErrors(result);
        if (errors != null) {
            return errors;
        }
        ContatoResponseDto response = contatoService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/contatos/remove/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        contatoService.remove(id);
        return ResponseEntity.noContent().build();
    }

    private ResponseEntity<?> validateErrors(BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .toList();

            return ResponseEntity.badRequest().body(errors);
        }
        return null;
    }
}

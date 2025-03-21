package com.muralis.sistemaGerenciamentoContantos.controller;

import com.muralis.sistemaGerenciamentoContantos.dto.ContatoDto;
import com.muralis.sistemaGerenciamentoContantos.dto.ContatoResponseDto;
import com.muralis.sistemaGerenciamentoContantos.service.ContatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContatoController {
    private final ContatoService contatoService;

    @PostMapping("/cliente/{id}/contatos/save")
    public ResponseEntity<ContatoResponseDto> saveContato(@PathVariable Long id, @RequestBody ContatoDto dto){
        ContatoResponseDto responseDto = contatoService.save(id, dto);
        URI uri = URI.create("/cliente/" + id + "/contatos");
        return ResponseEntity.created(uri).body(responseDto);
    }

    @GetMapping("/cliente/{id}/contatos")
    public ResponseEntity<List<ContatoResponseDto>> getContatos(@PathVariable Long id){
        List<ContatoResponseDto> contatos = contatoService.getContatos(id);
        return ResponseEntity.ok(contatos);
    }

    @PutMapping("/contatos/update/{id}")
    public ResponseEntity<ContatoResponseDto> updateContato(@PathVariable Long id, @RequestBody ContatoDto dto){
        ContatoResponseDto response = contatoService.update(id, dto);
        return  ResponseEntity.ok(response);
    }
}

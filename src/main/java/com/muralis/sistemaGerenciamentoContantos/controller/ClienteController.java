package com.muralis.sistemaGerenciamentoContantos.controller;

import com.muralis.sistemaGerenciamentoContantos.dto.ClientDto;
import com.muralis.sistemaGerenciamentoContantos.dto.ClienteResponseDto;
import com.muralis.sistemaGerenciamentoContantos.dto.ContatoDto;
import com.muralis.sistemaGerenciamentoContantos.dto.ContatoResponseDto;
import com.muralis.sistemaGerenciamentoContantos.service.ClienteService;
import com.muralis.sistemaGerenciamentoContantos.service.ContatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;
    private final ContatoService contatoService;

    @PostMapping("/save")
    public ResponseEntity<ClienteResponseDto> save(@RequestBody  ClientDto dto){
        ClienteResponseDto response = clienteService.save(dto);
        URI uri = URI.create("/cliente/" + response.getId());

        return ResponseEntity.created(uri).body(response);
    }

    @PostMapping("/{id}/contatos/save")
    public ResponseEntity<ContatoResponseDto> saveContato(@PathVariable Long id, @RequestBody ContatoDto dto){
        ContatoResponseDto responseDto = contatoService.save(id, dto);
        URI uri = URI.create("/cliente/" + id + "/contatos");
        return ResponseEntity.created(uri).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> getClients(
            @RequestParam(name = "nome", required = false) String name,
            @RequestParam(name = "cpf", required = false) String cpf
    ){
        List<ClienteResponseDto> clientes = clienteService.getClientes(name, cpf);
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}/contatos")
    public ResponseEntity<List<ContatoResponseDto>> getContatos(@PathVariable Long id){
        List<ContatoResponseDto> contatos = contatoService.getContatos(id);
        return ResponseEntity.ok(contatos);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClienteResponseDto> update(@PathVariable Long id, @RequestBody ClientDto dto){
        ClienteResponseDto response = clienteService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/remove/{id}")
    public  ResponseEntity<Void> remove(@PathVariable Long id){
        clienteService.remove(id);
        return ResponseEntity.noContent().build();
    }
}

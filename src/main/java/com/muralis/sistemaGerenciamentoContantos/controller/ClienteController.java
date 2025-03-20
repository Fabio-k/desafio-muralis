package com.muralis.sistemaGerenciamentoContantos.controller;

import com.muralis.sistemaGerenciamentoContantos.dto.ClientDto;
import com.muralis.sistemaGerenciamentoContantos.dto.ClienteResponseDto;
import com.muralis.sistemaGerenciamentoContantos.service.ClienteService;
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

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> getClients(){
        List<ClienteResponseDto> clientes = clienteService.getClientes();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping("/save")
    public ResponseEntity<ClienteResponseDto> save(@RequestBody  ClientDto dto){
        ClienteResponseDto response = clienteService.save(dto);

        URI uri = URI.create("/cliente/" + response.getId());

        return ResponseEntity.created(uri).body(response);
    }
}

package com.muralis.sistemaGerenciamentoContantos.controller;

import com.muralis.sistemaGerenciamentoContantos.dto.ClientDto;
import com.muralis.sistemaGerenciamentoContantos.dto.ClienteResponseDto;
import com.muralis.sistemaGerenciamentoContantos.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping("/save")
    public ResponseEntity<ClienteResponseDto> save(@RequestBody  ClientDto dto){
        ClienteResponseDto response = clienteService.save(dto);

        URI uri = URI.create("/cliente/" + response.getId());

        return ResponseEntity.created(uri).body(response);
    }
}

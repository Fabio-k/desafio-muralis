package com.muralis.sistemaGerenciamentoContantos.controller;

import com.muralis.sistemaGerenciamentoContantos.dto.ClientDto;
import com.muralis.sistemaGerenciamentoContantos.dto.ClienteContatoResponseDTO;
import com.muralis.sistemaGerenciamentoContantos.dto.ClienteResponseDto;
import com.muralis.sistemaGerenciamentoContantos.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid ClientDto dto, BindingResult result) {
        ResponseEntity<?> errors = validateErrors(result, null, dto.getCpf());
        if (errors != null) {
            return errors;
        }
        ClienteResponseDto response = clienteService.save(dto);
        URI uri = URI.create("/cliente/" + response.getId());

        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> getClients(
            @RequestParam(name = "nome", required = false) String name,
            @RequestParam(name = "cpf", required = false) String cpf) {
        List<ClienteResponseDto> clientes = clienteService.getClientes(name, cpf);
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteContatoResponseDTO> findCliente(@PathVariable Long id) {
        ClienteContatoResponseDTO response = clienteService.findClienteById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid ClientDto dto, BindingResult result) {
        ResponseEntity<?> errors = validateErrors(result, id, dto.getCpf());
        if (errors != null) {
            return errors;
        }
        ClienteResponseDto response = clienteService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        clienteService.remove(id);
        return ResponseEntity.noContent().build();
    }

    private ResponseEntity<?> validateErrors(BindingResult result,Long id, String cpf) {
        List<String> errors = new ArrayList<>();
        if (!clienteService.isCpfUnique(id, cpf)) {
            errors.add("CPF deve ser único");
        }
        if (result.hasErrors()) {
            List<String> validationErros = result.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .toList();
            errors.addAll(validationErros);
        }
        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors);
        }
        return null;
    }
}

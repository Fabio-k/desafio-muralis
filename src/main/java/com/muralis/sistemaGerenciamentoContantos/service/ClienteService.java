package com.muralis.sistemaGerenciamentoContantos.service;

import com.muralis.sistemaGerenciamentoContantos.dto.ClientDto;
import com.muralis.sistemaGerenciamentoContantos.dto.ClienteResponseDto;
import com.muralis.sistemaGerenciamentoContantos.entity.Cliente;
import com.muralis.sistemaGerenciamentoContantos.mapper.ClienteMapper;
import com.muralis.sistemaGerenciamentoContantos.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteResponseDto save(ClientDto dto){
        Cliente cliente = clienteMapper.toCliente(dto);

        return clienteMapper.toDto(clienteRepository.save(cliente));
    }

    public List<ClienteResponseDto> getClientes() {
        return clienteRepository.findAll().stream()
                .map(clienteMapper::toDto)
                .toList();
    }

    public ClienteResponseDto update(Long id, ClientDto dto) {
        Cliente cliente = findCliente(id);
        cliente.setCpf(dto.getCpf());
        cliente.setNome(dto.getNome());
        cliente.setData_nascimento(dto.getData_nascimento());
        cliente.setEndereco(dto.getEndereco());
        return clienteMapper.toDto(clienteRepository.save(cliente));
    }

    public void remove(Long id) {
        Cliente cliente = findCliente(id);
        clienteRepository.delete(cliente);
    }

    private Cliente findCliente(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
    }
}

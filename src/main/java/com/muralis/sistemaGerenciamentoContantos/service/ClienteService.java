package com.muralis.sistemaGerenciamentoContantos.service;

import com.muralis.sistemaGerenciamentoContantos.dto.ClientDto;
import com.muralis.sistemaGerenciamentoContantos.dto.ClienteResponseDto;
import com.muralis.sistemaGerenciamentoContantos.entity.Cliente;
import com.muralis.sistemaGerenciamentoContantos.mapper.ClienteMapper;
import com.muralis.sistemaGerenciamentoContantos.repository.ClienteRepository;
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
}

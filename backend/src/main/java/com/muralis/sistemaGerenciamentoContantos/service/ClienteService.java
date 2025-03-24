package com.muralis.sistemaGerenciamentoContantos.service;

import com.muralis.sistemaGerenciamentoContantos.dto.ClientDto;
import com.muralis.sistemaGerenciamentoContantos.dto.ClienteContatoResponseDTO;
import com.muralis.sistemaGerenciamentoContantos.dto.ClienteResponseDto;
import com.muralis.sistemaGerenciamentoContantos.entity.Cliente;
import com.muralis.sistemaGerenciamentoContantos.mapper.ClienteMapper;
import com.muralis.sistemaGerenciamentoContantos.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteResponseDto save(ClientDto dto) {
        Cliente cliente = clienteMapper.toCliente(dto);

        return clienteMapper.toDto(clienteRepository.save(cliente));
    }

    public List<ClienteResponseDto> getClientes(String nome, String cpf) {
        return clienteRepository.findWithFilter(formatParam(nome), formatParam(cpf)).stream()
                .map(clienteMapper::toDto)
                .toList();
    }

    public ClienteResponseDto update(Long id, ClientDto dto) {
        Cliente cliente = findCliente(id);
        cliente.setCpf(dto.getCpf());
        cliente.setNome(dto.getNome());
        cliente.setDataNascimento(dto.getDataNascimento());
        cliente.setEndereco(dto.getEndereco());
        return clienteMapper.toDto(clienteRepository.save(cliente));
    }

    public void remove(Long id) {
        Cliente cliente = findCliente(id);
        clienteRepository.delete(cliente);
    }

    public Cliente findCliente(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
    }

    public Boolean isCpfUnique(Long id, String cpf) {
        if (cpf == null)
            return false;
        Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);
        if (cliente.isEmpty() || id == null)
            return true;

        Cliente actualCliente = cliente.get();
        if (id.equals(actualCliente.getId())) {
            return true;
        }
        return false;
    }

    private String formatParam(String value) {
        if (value == null || value.trim().isEmpty())
            return null;
        return "%" + value + "%";
    }

    public ClienteContatoResponseDTO findClienteById(Long id) {
        Cliente cliente = findCliente(id);
        return clienteMapper.toClienteContatoDto(cliente);
    }
}

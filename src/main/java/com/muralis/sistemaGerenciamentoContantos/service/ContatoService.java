package com.muralis.sistemaGerenciamentoContantos.service;

import com.muralis.sistemaGerenciamentoContantos.dto.ContatoDto;
import com.muralis.sistemaGerenciamentoContantos.dto.ContatoResponseDto;
import com.muralis.sistemaGerenciamentoContantos.entity.Cliente;
import com.muralis.sistemaGerenciamentoContantos.entity.Contato;
import com.muralis.sistemaGerenciamentoContantos.mapper.ContatoMapper;
import com.muralis.sistemaGerenciamentoContantos.repository.ContatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContatoService {
    private final ContatoMapper contatoMapper;
    private final ClienteService clienteService;
    private final ContatoRepository contatoRepository;


    public ContatoResponseDto save(Long cliente_id, ContatoDto dto){
        Cliente cliente = clienteService.findCliente(cliente_id);
        Contato contato = contatoMapper.toContato(dto);
        contato.setCliente(cliente);
        return contatoMapper.toDto(contatoRepository.save(contato));
    }
}

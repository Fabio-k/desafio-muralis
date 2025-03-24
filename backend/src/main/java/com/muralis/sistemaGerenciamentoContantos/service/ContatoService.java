package com.muralis.sistemaGerenciamentoContantos.service;

import com.muralis.sistemaGerenciamentoContantos.dto.ContatoDto;
import com.muralis.sistemaGerenciamentoContantos.dto.ContatoResponseDto;
import com.muralis.sistemaGerenciamentoContantos.entity.Cliente;
import com.muralis.sistemaGerenciamentoContantos.entity.Contato;
import com.muralis.sistemaGerenciamentoContantos.mapper.ContatoMapper;
import com.muralis.sistemaGerenciamentoContantos.repository.ContatoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContatoService {
    private final ContatoMapper contatoMapper;
    private final ClienteService clienteService;
    private final ContatoRepository contatoRepository;

    public ContatoResponseDto save(Long cliente_id, ContatoDto dto) {
        Cliente cliente = clienteService.findCliente(cliente_id);
        Contato contato = contatoMapper.toContato(dto);
        contato.setCliente(cliente);
        return contatoMapper.toDto(contatoRepository.save(contato));
    }

    public List<ContatoResponseDto> getContatos(Long id) {
        Cliente cliente = clienteService.findCliente(id);

        return cliente.getContatos().stream().map(contatoMapper::toDto).toList();
    }

    public ContatoResponseDto update(Long id, ContatoDto dto) {
        Contato contato = findContato(id);
        contato.setTipo(dto.getTipo());
        contato.setValor(dto.getValor());
        contato.setObservacao(dto.getObservacao());
        return contatoMapper.toDto(contatoRepository.save(contato));
    }

    public void remove(Long id) {
        Contato contato = findContato(id);
        contatoRepository.delete(contato);
    }


    public ContatoResponseDto findContatoById(Long id) {
      Contato contato = findContato(id);
      return contatoMapper.toDto(contato);
    }


    private Contato findContato(Long id) {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contato não foi encontrado"));
    }
}

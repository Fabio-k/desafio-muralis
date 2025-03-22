package com.muralis.sistemaGerenciamentoContantos.mapper;

import com.muralis.sistemaGerenciamentoContantos.dto.ClientDto;
import com.muralis.sistemaGerenciamentoContantos.dto.ClienteContatoResponseDTO;
import com.muralis.sistemaGerenciamentoContantos.dto.ClienteResponseDto;
import com.muralis.sistemaGerenciamentoContantos.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ContatoMapper.class)
public interface ClienteMapper {
    Cliente toCliente(ClientDto clientSaveDto);

    ClienteResponseDto toDto(Cliente cliente);

    @Mapping(target = "contatos", source = "contatos")
    ClienteContatoResponseDTO toClienteContatoDto(Cliente cliente);
}

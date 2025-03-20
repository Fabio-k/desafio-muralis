package com.muralis.sistemaGerenciamentoContantos.mapper;

import com.muralis.sistemaGerenciamentoContantos.dto.ClientDto;
import com.muralis.sistemaGerenciamentoContantos.dto.ClienteResponseDto;
import com.muralis.sistemaGerenciamentoContantos.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente toCliente (ClientDto clientSaveDto);
    ClienteResponseDto toDto (Cliente cliente);
}

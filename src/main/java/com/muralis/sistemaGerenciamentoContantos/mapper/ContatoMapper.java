package com.muralis.sistemaGerenciamentoContantos.mapper;

import com.muralis.sistemaGerenciamentoContantos.dto.ContatoDto;
import com.muralis.sistemaGerenciamentoContantos.dto.ContatoResponseDto;
import com.muralis.sistemaGerenciamentoContantos.entity.Contato;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContatoMapper {
    @Mapping(target = "id", ignore = true) // Ignora o campo "id"
    @Mapping(target = "cliente", ignore = true) // Ignora o campo "cliente"
    Contato toContato(ContatoDto contatoDto);

    @Mapping(source = "cliente.id", target = "cliente_id")
    ContatoResponseDto toDto(Contato contato);
}

package com.br.natal;

import com.br.natal.entity.DTOs.GrupoDTO;
import com.br.natal.entity.Grupo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", implementationName = "GeneratedGrupoMapper")
public interface GrupoMapper {

    GrupoMapper INSTANCE = Mappers.getMapper(GrupoMapper.class);

    @Mapping(source = "data", target = "dataEvento")
    Grupo grupoDTOtoGrupo(GrupoDTO grupoDTO);
}

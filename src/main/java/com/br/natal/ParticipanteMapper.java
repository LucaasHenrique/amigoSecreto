package com.br.natal;

import com.br.natal.entity.DTOs.ParticipanteDTO;
import com.br.natal.entity.Participante;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ParticipanteMapper {

    ParticipanteMapper INSTANCE = Mappers.getMapper(ParticipanteMapper.class);

    Participante participanteDTOtoParticipante(ParticipanteDTO participanteDTO);
}

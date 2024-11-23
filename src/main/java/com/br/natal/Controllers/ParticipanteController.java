package com.br.natal.Controllers;

import com.br.natal.ParticipanteMapper;
import com.br.natal.entity.DTOs.ParticipanteDTO;
import com.br.natal.entity.Participante;
import com.br.natal.repository.GrupoRepository;
import com.br.natal.repository.ParticipanteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1")
public class ParticipanteController {

    private final ParticipanteRepository participanteRepository;
    private final GrupoRepository grupoRepository;
    private final ParticipanteMapper participanteMapper;

    public ParticipanteController(ParticipanteRepository participanteRepository, GrupoRepository grupoRepository, ParticipanteMapper participanteMapper) {
        this.participanteRepository = participanteRepository;
        this.grupoRepository = grupoRepository;
        this.participanteMapper = participanteMapper;
    }

    @PostMapping("/adicionarParticipante")
    public ResponseEntity<Void> adicionarParticipante(@RequestParam Long id, @RequestBody ParticipanteDTO participanteDTO) {

        Participante participante = ParticipanteMapper.INSTANCE.participanteDTOtoParticipante(participanteDTO);

        if (participanteRepository.existsByNome(participante.getNome())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Participante já existe");
        }

        grupoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Grupo não encontrado"));

        participanteRepository.save(participante);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

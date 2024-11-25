package com.br.natal.Controllers;

import com.br.natal.entity.DTOs.AmigoSecretoDTO;
import com.br.natal.entity.Grupo;
import com.br.natal.entity.Participante;
import com.br.natal.repository.GrupoRepository;
import com.br.natal.repository.ParticipanteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@RestController
public class AmigoSecretoController {

    private final GrupoRepository grupoRepository;
    private final ParticipanteRepository participanteRepository;

    public AmigoSecretoController(GrupoRepository grupoRepository, ParticipanteRepository participanteRepository) {
        this.grupoRepository = grupoRepository;
        this.participanteRepository = participanteRepository;
    }

    @PostMapping("/grupos/{id}/sorteio")
    public ResponseEntity<Object> sortearAmigo(@PathVariable Long id) {

        Grupo grupo = grupoRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Grupo não encontrado"));

        List<Participante> participantes = participanteRepository.findByGrupoId(grupo.getId());

        if (participantes.size() < 2) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Número insuficiente de partipantes");
        }

        Collections.shuffle(participantes);

        for (int i = 0; i < participantes.size(); i++) {
            Participante atual = participantes.get(i);
            Participante amigoSecreto = participantes.get((i + 1) % participantes.size());
            atual.setAmigoSecreto(amigoSecreto);
            participanteRepository.save(atual);
        }

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/participantes/{id}")
    public ResponseEntity<AmigoSecretoDTO> consultarAmigo(@PathVariable Long id) {

        Participante participante = participanteRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Participante não encontrado!"));

        Participante amigoSecreto = participante.getAmigoSecreto();
        AmigoSecretoDTO amigoSecretoDTO = new AmigoSecretoDTO(amigoSecreto.getId(), amigoSecreto.getNome());

        return ResponseEntity.ok(amigoSecretoDTO);
    }
}

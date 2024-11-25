package com.br.natal.Controllers;

import com.br.natal.entity.DTOs.GrupoDTO;
import com.br.natal.entity.Grupo;
import com.br.natal.GrupoMapper;
import com.br.natal.repository.GrupoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class GrupoController {
    
    private final GrupoRepository grupoRepository;
    private final GrupoMapper grupoMapper;

    public GrupoController(GrupoRepository grupoRepository1, GrupoMapper grupoMapper) {
        this.grupoRepository = grupoRepository1;
        this.grupoMapper = grupoMapper;
    }

    @PostMapping("/criarGrupo")
    public ResponseEntity<Void> criarGrupo (@RequestBody GrupoDTO grupoDTO) {
        Grupo grupo = GrupoMapper.INSTANCE.grupoDTOtoGrupo(grupoDTO);

        if (grupoRepository.existsByNome(grupo.getNome())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        grupoRepository.save(grupo);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

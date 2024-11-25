package com.br.natal.repository;

import com.br.natal.entity.Grupo;
import com.br.natal.entity.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

    Boolean existsByNome(String nome);
    List<Participante> findByGrupoId(Long id);

    Participante findParticipanteById(Long id);
}

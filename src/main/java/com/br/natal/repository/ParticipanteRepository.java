package com.br.natal.repository;

import com.br.natal.entity.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

    Boolean existsByNome(String nome);
}

package com.br.natal.repository;

import com.br.natal.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {

    Boolean existsByNome(String nome);
    Optional<Grupo> findByNome(String nome);
}

package com.AtividadeProposta.Atividade.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AtividadeProposta.Atividade.Entity.PessoaEntity;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer>{

	Optional <PessoaEntity> findByNome(String nome);
}

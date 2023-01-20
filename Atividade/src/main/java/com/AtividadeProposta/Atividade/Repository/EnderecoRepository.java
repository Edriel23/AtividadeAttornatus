package com.AtividadeProposta.Atividade.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AtividadeProposta.Atividade.Entity.EnderecoEntity;

@Repository
public interface EnderecoRepository extends JpaRepository <EnderecoEntity, Integer>{

	List <EnderecoEntity> findByPessoaId(Integer Id);
	Optional <EnderecoEntity> findByFlPrincipalAndPessoaId (Boolean Principal, Integer PessoaId);
}

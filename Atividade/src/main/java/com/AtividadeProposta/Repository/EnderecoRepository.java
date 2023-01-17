package com.AtividadeProposta.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AtividadeProposta.Entity.EnderecoEntity;

@Repository
public interface EnderecoRepository extends JpaRepository <EnderecoEntity, Integer>{

}

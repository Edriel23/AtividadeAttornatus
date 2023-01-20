package com.AtividadeProposta.Atividade.Dto;

import java.util.List;

import com.AtividadeProposta.Atividade.Entity.PessoaEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDto {
	
	private Integer id;
	
	private String logradouro;
	private String cep;
	private Integer numero;
	private String cidade;
	private Boolean flPrincipal;
	private List<PessoaEntity> pessoa;
}

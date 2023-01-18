package com.AtividadeProposta.Dto;

import java.util.List;

import com.AtividadeProposta.Entity.PessoaEntity;

import lombok.Data;

@Data
public class EnderecoDto {
	
	private Integer Id;
	
	private String Logradouro;
	private String CEP;
	private Integer Numero;
	private String Cidade;
	private Boolean FlPrincipal;
	private List<PessoaEntity> pessoa;
}

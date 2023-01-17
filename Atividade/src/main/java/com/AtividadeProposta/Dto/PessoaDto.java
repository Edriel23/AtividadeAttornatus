package com.AtividadeProposta.Dto;

import java.time.LocalDate;
import java.util.List;

import com.AtividadeProposta.Entity.EnderecoEntity;

import lombok.Data;

@Data
public class PessoaDto {

	private Integer Id;
	
	private String Nome;
	private LocalDate DataDeNacimento;
	
	private List<EnderecoEntity> pessoa;
}

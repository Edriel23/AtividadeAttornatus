package com.AtividadeProposta.Dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PessoaDto {

	private Integer Id;
	
	private String Nome;
	private LocalDate DataDeNacimento;

}

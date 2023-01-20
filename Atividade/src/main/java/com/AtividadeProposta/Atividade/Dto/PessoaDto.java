package com.AtividadeProposta.Atividade.Dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDto {

	private Integer id;
	private String nome;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataDeNacimento;

}

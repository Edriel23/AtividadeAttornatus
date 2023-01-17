package com.AtividadeProposta.Dto;

import lombok.Data;

@Data
public class EnderecoDto {
	
	private Integer Id;
	
	private String Logradouro;
	private String CEP;
	private Integer Numero;
	private String Cidade;
}

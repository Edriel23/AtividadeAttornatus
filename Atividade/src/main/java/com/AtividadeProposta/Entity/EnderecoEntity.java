package com.AtividadeProposta.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "Endereco")
@Data
public class EnderecoEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	private String Logradouro;
	private String CEP;
	private Integer Numero;
	private String Cidade;
	private Boolean FlPrincipal ;
	@ManyToMany
	@JoinTable (name = "Pessoa_Endereco",
			joinColumns = @JoinColumn (name = "Endereco_id"),
			inverseJoinColumns = @JoinColumn(name = "Pessoa_id"))
	List<PessoaEntity> pessoa;
}

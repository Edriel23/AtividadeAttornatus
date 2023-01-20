package com.AtividadeProposta.Atividade.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name = "endereco")
@Data
public class EnderecoEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String logradouro;
	private String cep;
	private Integer numero;
	private String cidade;
	private Boolean flPrincipal ;
	@ManyToMany
	@JoinTable (name = "pessoa_endereco",
			joinColumns = @JoinColumn (name = "endereco_id"),
			inverseJoinColumns = @JoinColumn(name = "pessoa_id"))
	List<PessoaEntity> pessoa;
}

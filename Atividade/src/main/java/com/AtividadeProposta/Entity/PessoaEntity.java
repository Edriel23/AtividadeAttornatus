package com.AtividadeProposta.Entity;

import java.time.LocalDate;
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
@Table (name = "Pessoa")
@Data
public class PessoaEntity {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	private String Nome;
	private LocalDate DataDeNacimento;
	
	@ManyToMany
	@JoinTable (name = "Pessoa_Endereco",
			joinColumns = @JoinColumn (name = "Pessoa_id"),
			inverseJoinColumns = @JoinColumn(name = "Endereco_id"))
	List<EnderecoEntity> pessoa;

}

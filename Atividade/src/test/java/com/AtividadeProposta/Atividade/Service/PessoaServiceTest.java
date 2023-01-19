package com.AtividadeProposta.Atividade.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.AtividadeProposta.Atividade.AtividadeApplicationTests;
import com.AtividadeProposta.Dto.PessoaDto;
import com.AtividadeProposta.Repository.PessoaRepository;
import com.AtividadeProposta.Service.PessoaService;

public class PessoaServiceTest extends AtividadeApplicationTests {
	
	
	/*@MockBean 
	PessoaRepository pessoaRepository;
	
	@MockBean
	ModelMapper mapper;
	
	@Autowired
	PessoaService pessoaService;
	
	@Test
	public void testeSalvarSucesso() {
		PessoaDto pessoaSalva = pessoaService.salvar(criarPessoa());
		assertEquals(pessoaSalva, criarPessoa());
	}

	private PessoaDto criarPessoa() {
		PessoaDto pessoa = new PessoaDto();
		pessoa.setId(1);
		pessoa.setNome("Edriel");
		pessoa.setDataDeNacimento(LocalDate.of(2001, 4, 23));
		return pessoa;
	}*/
}

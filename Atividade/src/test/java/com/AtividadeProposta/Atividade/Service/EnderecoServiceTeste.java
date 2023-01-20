package com.AtividadeProposta.Atividade.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.AtividadeProposta.Atividade.AtividadeApplicationTests;
import com.AtividadeProposta.Atividade.Dto.EnderecoDto;
import com.AtividadeProposta.Atividade.Dto.PessoaDto;
import com.AtividadeProposta.Atividade.Entity.EnderecoEntity;
import com.AtividadeProposta.Atividade.Repository.EnderecoRepository;

public class EnderecoServiceTeste extends AtividadeApplicationTests {

	
	@MockBean
	EnderecoRepository enderecoRepository;
	
	@Autowired 
	EnderecoService enderecoService;
	
	
	@Test
	public void salvarEnderecoSucesso() {
		EnderecoDto endereco = criarEndereco();
		when(enderecoRepository.save(any(EnderecoEntity.class))).thenReturn(criarEnderecoEntity());
		EnderecoDto enderecoSalvo = enderecoService.salvar(endereco);
		assertEquals(enderecoSalvo.getId(), endereco.getId());
	}
	
	@Test
	public void buscarEnderecoPrincipal() {
		when(enderecoRepository.findByFlPrincipalAndPessoaId(any(true, Integer.class))).thenReturn(Optional.ofNullable(criarEnderecoEntity()));
		EnderecoDto enderecoPrincipal = enderecoService.buscarEnderecoPrincipal(1);
		assertEquals(enderecoPrincipal.getId(),criarEnderecoEntity().getId());
	}
	
	private EnderecoDto criarEndereco() {
		EnderecoDto endereco = new EnderecoDto();
		endereco.setId(1);
		endereco.setLogradouro("Casa");
		endereco.setCep("38185-000");
		endereco.setNumero(247);
		endereco.setCidade("Tapira");
		endereco.setFlPrincipal(true);
		endereco.getPessoa();
		return endereco;
	}
	
	private EnderecoEntity criarEnderecoEntity() {
		EnderecoEntity enderecoEntity = new EnderecoEntity();
		enderecoEntity.setId(1);
		enderecoEntity.setLogradouro("Casa");
		enderecoEntity.setCep("38185-000");
		enderecoEntity.setNumero(247);
		enderecoEntity.setCidade("Tapira");
		enderecoEntity.setFlPrincipal(true);
		enderecoEntity.setPessoa(null);
		return enderecoEntity;
	}
}

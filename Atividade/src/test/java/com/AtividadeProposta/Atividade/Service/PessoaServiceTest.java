package com.AtividadeProposta.Atividade.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.AtividadeProposta.Atividade.AtividadeApplicationTests;
import com.AtividadeProposta.Atividade.Dto.PessoaDto;
import com.AtividadeProposta.Atividade.Entity.PessoaEntity;
import com.AtividadeProposta.Atividade.Repository.PessoaRepository;


public class PessoaServiceTest extends AtividadeApplicationTests {
	
	@MockBean 
	PessoaRepository pessoaRepository;
	
	@Autowired
	PessoaService pessoaService;
	
	@Test
	public void testeSalvarSucesso() {
		PessoaDto pessoa = criarPessoa();
		when(pessoaRepository.save(any(PessoaEntity.class))).thenReturn(criarPessoaEntity());
		PessoaDto pessoaSalva = pessoaService.salvar(pessoa);
		assertEquals(pessoaSalva.getId(), pessoa.getId());
	}
	@Test
	public void buscarPessoa() {
		when(pessoaRepository.findByNome(any(String.class))).thenReturn(Optional.ofNullable(criarPessoaEntity()));
		PessoaDto pessoaBuscada = pessoaService.buscarPessoa("Edriel");
		assertEquals(pessoaBuscada.getId(),criarPessoaEntity().getId());
	}
	
	@Test
	public void buscarPessoaComErro() {
		when(pessoaRepository.findByNome(any(String.class))).thenReturn(Optional.ofNullable(null));
		assertThrows(RuntimeException.class, ()-> pessoaService.buscarPessoa("Edriel"));
	}
	
	@Test 
	public void buscarListaDePessoa() {
		when(pessoaRepository.findAll()).thenReturn(criarListaPessoaEntity());
		List <PessoaDto> pessoaDto = pessoaService.getAllPessoas();
		assertEquals(pessoaDto.size(), criarListaDePessoa().size());
	}

	private PessoaDto criarPessoa() {
		PessoaDto pessoa = new PessoaDto();
		pessoa.setId(1);
		pessoa.setNome("Edriel");
		pessoa.setDataDeNacimento(LocalDate.of(2001, 4, 23));
		return pessoa;
	}
	
	private PessoaEntity criarPessoaEntity() {
		PessoaEntity pessoa = new PessoaEntity();
		pessoa.setId(1);
		pessoa.setNome("Edriel");
		pessoa.setDataDeNacimento(LocalDate.of(2001, 4, 23));
		return pessoa;
	}
	
	private List<PessoaDto> criarListaDePessoa(){
		List<PessoaDto> lista  = new ArrayList<>();
		lista.add(criarPessoa());
		return lista;
		//lista.size()
	}
	
	private List<PessoaEntity> criarListaPessoaEntity(){
		List<PessoaEntity> listaEntity = new ArrayList<>();
		listaEntity.add(criarPessoaEntity());
		return listaEntity;
	}
}

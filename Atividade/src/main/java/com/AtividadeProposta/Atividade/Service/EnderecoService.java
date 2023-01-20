package com.AtividadeProposta.Atividade.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AtividadeProposta.Atividade.Dto.EnderecoDto;
import com.AtividadeProposta.Atividade.Entity.EnderecoEntity;
import com.AtividadeProposta.Atividade.Repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	
	@Autowired 
	EnderecoRepository enderecoRepository;
	
	@Autowired
	ModelMapper mapper;
	
	public EnderecoDto salvar (EnderecoDto Endereco) {
		EnderecoEntity enderecoEntity = enderecoRepository.save(mapper.map(Endereco, EnderecoEntity.class));
		return mapper.map(enderecoEntity, EnderecoDto.class);
	}
	
	public EnderecoDto buscarEnderecoPrincipal(Integer IdPessoa) {
		Optional <EnderecoEntity> enderecoEntity = enderecoRepository.findByFlPrincipalAndPessoaId(true, IdPessoa);
		return mapper.map(enderecoEntity.get(), EnderecoDto.class);
	}	

}

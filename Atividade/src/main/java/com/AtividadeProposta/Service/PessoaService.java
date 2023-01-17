package com.AtividadeProposta.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AtividadeProposta.Dto.PessoaDto;
import com.AtividadeProposta.Entity.PessoaEntity;
import com.AtividadeProposta.Repository.PessoaRepository;

@Service
public class PessoaService {
	
	
	@Autowired 
	PessoaRepository pessoaRepository;
	
	@Autowired
	ModelMapper mapper;
	
	
	public PessoaDto salvar (PessoaDto Pessoa) {
		PessoaEntity pessoaEntity = pessoaRepository.save(mapper.map(Pessoa, PessoaEntity.class));
		return mapper.map(pessoaEntity, PessoaDto.class);
	}
	
	public PessoaDto buscarPessoa (String pessoa) {
		Optional <PessoaEntity> pessoaEntity = pessoaRepository.findByPessoa(pessoa);
		if (pessoaEntity.isPresent()) {
			return mapper.map(pessoaEntity.get(), PessoaDto.class);
		}else {
			throw new RuntimeException("A pessoa não Exixte!!");
		}
	}
	
	public List <PessoaDto> getAllPessoas() {
		return pessoaRepository.findAll()
				.stream()
				.map(a -> mapper.map(a, PessoaDto.class))
				.collect(Collectors.toList());
	}
	

}

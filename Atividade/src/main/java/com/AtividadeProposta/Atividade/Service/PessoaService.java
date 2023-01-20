package com.AtividadeProposta.Atividade.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AtividadeProposta.Atividade.Dto.PessoaDto;
import com.AtividadeProposta.Atividade.Entity.PessoaEntity;
import com.AtividadeProposta.Atividade.Repository.PessoaRepository;

@Service
public class PessoaService {
	
	
	@Autowired 
	PessoaRepository pessoaRepository;
	
	@Autowired
	ModelMapper mapper;
	
	
	public PessoaDto salvar (PessoaDto pessoa) {
		PessoaEntity pessoaEntity = pessoaRepository.save(mapper.map(pessoa, PessoaEntity.class));
		return mapper.map(pessoaEntity, PessoaDto.class);
	}
	
	public PessoaDto buscarPessoa (String nome){
		Optional <PessoaEntity> pessoaEntity = pessoaRepository.findByNome(nome);
		if (pessoaEntity.isPresent()) {
			return mapper.map(pessoaEntity.get(), PessoaDto.class);
		}else {
			throw new RuntimeException("A pessoa não Exixte!!");
		}
	}
	
	public PessoaDto buscarPessoaId (Integer id) {
		Optional <PessoaEntity> pessoaEntity = pessoaRepository.findById(id);
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
	
	public PessoaDto editar (PessoaDto pessoaDto, Integer id) {
		PessoaEntity pessoaEntity = pessoaRepository.findById(id).get();
		PessoaEntity pessoa = mapper.map(pessoaDto, PessoaEntity.class );
		pessoaEntity.setNome(pessoa.getNome());
		pessoaEntity.setDataDeNacimento(pessoa.getDataDeNacimento());
		pessoaRepository.save(pessoaEntity);
		return mapper.map(pessoaEntity, PessoaDto.class);
	}
}

package com.AtividadeProposta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.AtividadeProposta.Dto.PessoaDto;
import com.AtividadeProposta.Service.PessoaService;

@Controller
@RequestMapping (name = "pessoa")
public class PessoaController {

	
	@Autowired 
	PessoaService pessoaService;
	
	@ResponseBody
	@PostMapping ("/salvar")
	public ResponseEntity<?> salvarPessoa (@RequestBody PessoaDto pessoa){
		return new ResponseEntity<> (pessoaService.salvar(pessoa), HttpStatus.CREATED);
	}
	
	@ResponseBody
	@GetMapping ("/buscarPessoaId")
	public ResponseEntity<?> buscarPessoaId (@RequestParam Integer id){
		try {
			return new ResponseEntity<>(pessoaService.buscarPessoaId(id), HttpStatus.OK);
		}catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@ResponseBody
	@GetMapping ("/buscarPessoa")
	public ResponseEntity<?> buscarPessoaNome (@RequestParam String Nome){
		try {
			return new ResponseEntity<>(pessoaService.buscarPessoa(Nome), HttpStatus.OK);
		}catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@ResponseBody 
	@GetMapping ("/buscarTodos")
	public List <PessoaDto> getAllPessoas() {
		return pessoaService.getAllPessoas();
	}
	
	@ResponseBody
	@PostMapping ("/editar")
	public ResponseEntity<?> editarPessoa (@RequestBody PessoaDto pessoa, @RequestParam Integer id){
		return new ResponseEntity<> (pessoaService.editar(pessoa, id), HttpStatus.OK);
	}
}

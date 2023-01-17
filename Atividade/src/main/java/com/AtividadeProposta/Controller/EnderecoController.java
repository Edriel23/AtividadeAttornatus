package com.AtividadeProposta.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.AtividadeProposta.Dto.EnderecoDto;
import com.AtividadeProposta.Service.EnderecoService;

@Controller
public class EnderecoController {
	
	
	@Autowired
	EnderecoService enderecoService;
	
	@ResponseBody 
	@PostMapping ("/salvar")
	public ResponseEntity<?> salvarEndereco (@RequestBody EnderecoDto Endereco){
		return new ResponseEntity<> (enderecoService.salvar(Endereco),HttpStatus.CREATED);
	}

}

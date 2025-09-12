package br.app.alfabetizei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.app.alfabetizei.dto.UsuarioCriarDto;
import br.app.alfabetizei.dto.UsuarioDto;
import br.app.alfabetizei.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/logado")
	public ResponseEntity<UsuarioDto> criar(){
		UsuarioDto usuario = service.buscarLogado();
		if(usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping("/criar")
	public ResponseEntity<UsuarioDto> criar(@RequestBody UsuarioCriarDto dados){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dados));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<UsuarioDto> atualizar(@RequestBody UsuarioDto dados){
		return ResponseEntity.ok(service.atualizar(dados));	
	}
}

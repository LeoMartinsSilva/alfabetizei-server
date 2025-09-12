package br.app.alfabetizei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.app.alfabetizei.dto.ImageDto;
import br.app.alfabetizei.dto.atividadePai.AtividadePaiResumoDto;
import br.app.alfabetizei.dto.atividadePai.AtividadePaiUsuarioDto;
import br.app.alfabetizei.service.atividadePai.AtividadePaiService;

@RestController
@RequestMapping("/atividadePai")
public class AtividadePaiController {

	@Autowired
	private AtividadePaiService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<AtividadePaiUsuarioDto>> buscarTodos(){
		return ResponseEntity.ok(service.buscarAtividadesPai());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AtividadePaiUsuarioDto> buscarPorId(@PathVariable Long id){
		return ResponseEntity.ok(service.buscarAtividade(id));
	}
	
	@PutMapping("/marcarComoFeito/{id}")
	public ResponseEntity<Void> finalizarAtividade(@PathVariable Long id){
		service.marcarComoFeito(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/resumo")
	public ResponseEntity<AtividadePaiResumoDto> buscarResumo(){
		return ResponseEntity.ok(service.buscarResumo());
	}
	
	@GetMapping("/imagem/{id}/{sequencial}")
	public ResponseEntity<byte[]> buscarImagem(@PathVariable Long id, @PathVariable Integer sequencial){
		ImageDto image = service.getImage(id, sequencial);
		return ResponseEntity.ok().contentType(image.getType()).body(image.getBytes());
	}
}

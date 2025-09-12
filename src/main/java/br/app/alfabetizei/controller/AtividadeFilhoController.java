package br.app.alfabetizei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.app.alfabetizei.dto.ImageDto;
import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoResumoDto;
import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoUsuarioDto;
import br.app.alfabetizei.dto.atividadeFilho.responder.AtividadeContarSilabasResponderDto;
import br.app.alfabetizei.dto.atividadeFilho.responder.AtividadeEscolhaDuasOpcoesResponderDto;
import br.app.alfabetizei.dto.atividadeFilho.responder.AtividadeEscolhaResponderDto;
import br.app.alfabetizei.dto.atividadeFilho.responder.AtividadeLetrasPontilhadasResponderDto;
import br.app.alfabetizei.service.atividadeFilho.AtividadeFilhoService;
import br.app.alfabetizei.util.AudioUtil;

@RestController
@RequestMapping("/atividadeFilho")
public class AtividadeFilhoController {

	@Autowired
	private AtividadeFilhoService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<AtividadeFilhoUsuarioDto>> buscarTodos(){
		return ResponseEntity.ok(service.buscarAtividadesFilho());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AtividadeFilhoUsuarioDto> buscarPorId(@PathVariable Long id){
		return ResponseEntity.ok(service.buscarAtividade(id));
	}
	
	@GetMapping("/imagem/escolhaOpcao/{idAtividade}/{sequencial}/{sequencialOpcao}")
	public ResponseEntity<byte[]> buscarImagemOpcao(@PathVariable Long idAtividade, @PathVariable Long sequencial, @PathVariable Long sequencialOpcao){
		ImageDto image = service.buscarImagemOpcao(idAtividade, sequencial, sequencialOpcao);
		return ResponseEntity.ok().contentType(image.getType()).body(image.getBytes());
	}
	
	@GetMapping("/imagem/contarSilabas/{idAtividade}/{sequencial}")
	public ResponseEntity<byte[]> buscarImagemContarSilabas(@PathVariable Long idAtividade, @PathVariable Long sequencial){
		ImageDto image = service.buscarImagemContarSilabas(idAtividade, sequencial);
		return ResponseEntity.ok().contentType(image.getType()).body(image.getBytes());
	}
	
	@GetMapping("/audio/{idAtividade}/{sequencial}")
    public ResponseEntity<Resource> getAudio(@PathVariable Long idAtividade, @PathVariable Long sequencial) {
        try {
            ClassPathResource audioFile = AudioUtil.getAudio("audios/atividade_filho/" + idAtividade + "/"+ sequencial);
            if(audioFile!=null) {
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType("audio/mpeg"))
                        .body(audioFile);
            	
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
	@GetMapping("/resumo")
	public ResponseEntity<AtividadeFilhoResumoDto> buscarResumo(){
		return ResponseEntity.ok(service.buscarResumo());
	}
	
	@PostMapping("/responder/letrasPontilhadas")
	public ResponseEntity<Void> responderLetrasPontilhadas(@RequestBody AtividadeLetrasPontilhadasResponderDto dados){
		service.responderItemLetrasPontilhadas(dados);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/responder/escolha")
	public ResponseEntity<Void> responderEscolha(@RequestBody AtividadeEscolhaResponderDto dados){
		service.responderItemEscolha(dados);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/responder/escolhaDuasOpcoes")
	public ResponseEntity<Void> responderEscolhaDuasOpcoes(@RequestBody AtividadeEscolhaDuasOpcoesResponderDto dados){
		service.responderItemEscolha(dados);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/responder/contarSilabas")
	public ResponseEntity<Void> responderContarSilabas(@RequestBody AtividadeContarSilabasResponderDto dados){
		service.responderItemContarSilabas(dados);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/finalizar/{id}")
	public ResponseEntity<Void> finalizarAtividade(@PathVariable Long id){
		service.finalizarAtividade(id);
		return ResponseEntity.ok().build();
	}
}

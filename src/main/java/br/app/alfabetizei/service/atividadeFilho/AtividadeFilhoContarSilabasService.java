package br.app.alfabetizei.service.atividadeFilho;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoContarSilabasUsuarioDto;
import br.app.alfabetizei.dto.atividadeFilho.responder.AtividadeContarSilabasResponderDto;
import br.app.alfabetizei.enums.StatusAtividadeFilhoItemEnum;
import br.app.alfabetizei.mapper.atividadeFilho.AtividadeFilhoContarSilabasUsuarioMapper;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoContarSilabas;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoContarSilabasUsuario;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoUsuario;
import br.app.alfabetizei.repository.atividadeFilho.AtividadeFilhoContarSilabasRepository;
import br.app.alfabetizei.repository.atividadeFilho.AtividadeFilhoContarSilabasUsuarioRepository;
import br.app.alfabetizei.service.UsuarioLogadoService;
import jakarta.transaction.Transactional;

@Service
public class AtividadeFilhoContarSilabasService {
	
	@Autowired
	private AtividadeFilhoContarSilabasRepository repository;
	
	@Autowired
	private AtividadeFilhoContarSilabasUsuarioRepository atividadeFilhoContarSilabasUsuarioRepository;
	
	@Autowired
	private AtividadeFilhoContarSilabasUsuarioMapper atividadeFilhoContarSilabasUsuarioMapper;
	
	@Autowired
	private UsuarioLogadoService usuarioLogadoService;
	
	@Transactional
	public List<AtividadeFilhoContarSilabasUsuarioDto> buscarPorAtividade(AtividadeFilhoUsuario atividadeFilhoUsuario){
		List<AtividadeFilhoContarSilabasUsuarioDto> itensUsuario = atividadeFilhoContarSilabasUsuarioMapper.toDto(atividadeFilhoContarSilabasUsuarioRepository.findAllByAtividadeFilhoUsuarioIdOrderBySequencial(atividadeFilhoUsuario.getId()));
		if(itensUsuario.size() == 0) {
			List<AtividadeFilhoContarSilabas> itens = repository.findAllByAtividadeFilhoId(atividadeFilhoUsuario.getAtividadeFilho().getId());
			for(AtividadeFilhoContarSilabas item : itens) {
				AtividadeFilhoContarSilabasUsuario itemUsuario = new AtividadeFilhoContarSilabasUsuario();
				itemUsuario.setAtividadeFilhoUsuario(atividadeFilhoUsuario);
				itemUsuario.setNumeroSilabas(item.getNumeroSilabas());
				itemUsuario.setPalavra(item.getPalavra());
				itemUsuario.setSequencial(item.getSequencial());
				itemUsuario.setStatus(StatusAtividadeFilhoItemEnum.PENDENTE.getCodigo());
				itemUsuario = atividadeFilhoContarSilabasUsuarioRepository.save(itemUsuario);
				itensUsuario.add(atividadeFilhoContarSilabasUsuarioMapper.toDto(itemUsuario));
			}
		}
		return itensUsuario;
	}

	@Transactional
	public void responder(AtividadeContarSilabasResponderDto dados) {
		Long idUsuario = usuarioLogadoService.getUsuarioLogado().getId();
		
		Optional<AtividadeFilhoContarSilabasUsuario> optional = atividadeFilhoContarSilabasUsuarioRepository.findById(dados.getIdAtividadeFilhoContarSilabasUsuario());
		if(optional.isPresent()) {
			AtividadeFilhoContarSilabasUsuario item = optional.get();
			
			if(!idUsuario.equals(item.getAtividadeFilhoUsuario().getUsuario().getId())) {
				throw new RuntimeException("Essa atividade não pertence ao seu usuário");
			}
			
			item.setStatus(StatusAtividadeFilhoItemEnum.FINALIZADA.getCodigo());
			item.setNumeroSilabasSelecionada(dados.getNumeroDeSilabasEscolhido());
			item.setAcertou(dados.getNumeroDeSilabasEscolhido().equals(item.getNumeroSilabas()));
		}
		
	}

	public Integer buscarNotaPorAtividade(Long idAtividadeUsuario) {
		List<AtividadeFilhoContarSilabasUsuarioDto> itens = atividadeFilhoContarSilabasUsuarioMapper.toDto(atividadeFilhoContarSilabasUsuarioRepository.findAllByAtividadeFilhoUsuarioIdOrderBySequencial(idAtividadeUsuario));
		int nota = 0;
		for(AtividadeFilhoContarSilabasUsuarioDto item : itens) {
			if(item.getAcertou()) {
				nota++;
			}
		}
		return nota;
	}
}

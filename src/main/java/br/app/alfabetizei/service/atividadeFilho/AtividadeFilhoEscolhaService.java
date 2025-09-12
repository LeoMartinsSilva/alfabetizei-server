package br.app.alfabetizei.service.atividadeFilho;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoEscolhaOpcaoUsuarioDto;
import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoEscolhaUsuarioDto;
import br.app.alfabetizei.dto.atividadeFilho.responder.AtividadeEscolhaDuasOpcoesResponderDto;
import br.app.alfabetizei.dto.atividadeFilho.responder.AtividadeEscolhaResponderDto;
import br.app.alfabetizei.enums.StatusAtividadeFilhoItemEnum;
import br.app.alfabetizei.mapper.atividadeFilho.AtividadeFilhoEscolhaUsuarioMapper;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoEscolha;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoEscolhaUsuario;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoUsuario;
import br.app.alfabetizei.repository.atividadeFilho.AtividadeFilhoEscolhaRepository;
import br.app.alfabetizei.repository.atividadeFilho.AtividadeFilhoEscolhaUsuarioRepository;
import br.app.alfabetizei.service.UsuarioLogadoService;
import jakarta.transaction.Transactional;

@Service
public class AtividadeFilhoEscolhaService {
	
	@Autowired
	private AtividadeFilhoEscolhaRepository repository;
	
	@Autowired
	private AtividadeFilhoEscolhaUsuarioRepository atividadeFilhoEscolhaUsuarioRepository;
	
	@Autowired
	private AtividadeFilhoEscolhaUsuarioMapper atividadeFilhoEscolhaUsuarioMapper;
	
	@Autowired
	private AtividadeFilhoEscolhaOpcaoService opcaoService;
	
	@Autowired
	private UsuarioLogadoService usuarioLogadoService;
	
	@Transactional
	public List<AtividadeFilhoEscolhaUsuarioDto> buscarPorAtividade(AtividadeFilhoUsuario atividadeFilhoUsuario){
		List<AtividadeFilhoEscolhaUsuarioDto> itensUsuario = atividadeFilhoEscolhaUsuarioMapper.toDto(atividadeFilhoEscolhaUsuarioRepository.findAllByAtividadeFilhoUsuarioIdOrderBySequencial(atividadeFilhoUsuario.getId()));
		if(itensUsuario.size() == 0) {
			List<AtividadeFilhoEscolha> itens = repository.findAllByAtividadeFilhoId(atividadeFilhoUsuario.getAtividadeFilho().getId());
			for(AtividadeFilhoEscolha item : itens) {
				AtividadeFilhoEscolhaUsuario itemUsuario = new AtividadeFilhoEscolhaUsuario();
				itemUsuario.setAtividadeFilhoUsuario(atividadeFilhoUsuario);
				itemUsuario.setSequencial(item.getSequencial());
				itemUsuario.setStatus(StatusAtividadeFilhoItemEnum.PENDENTE.getCodigo());
				itemUsuario = atividadeFilhoEscolhaUsuarioRepository.save(itemUsuario);
				
				List<AtividadeFilhoEscolhaOpcaoUsuarioDto> opcoes = opcaoService.buscarPorAtividadeId(itemUsuario, item.getId());
				
				AtividadeFilhoEscolhaUsuarioDto itemUsuarioDto = atividadeFilhoEscolhaUsuarioMapper.toDto(itemUsuario);
				itemUsuarioDto.setOpcoes(opcoes);
				
				itensUsuario.add(itemUsuarioDto);
			}
		} else {
			for(AtividadeFilhoEscolhaUsuarioDto itemUsuario : itensUsuario) {
				itemUsuario.setOpcoes(opcaoService.buscarPorAtividadeId(atividadeFilhoEscolhaUsuarioMapper.toEntity(itemUsuario), 0l));
			}
		}
		
		return itensUsuario;
	}

	@Transactional
	public void responder(AtividadeEscolhaResponderDto dados) {
		Long idUsuario = usuarioLogadoService.getUsuarioLogado().getId();
		
		Optional<AtividadeFilhoEscolhaUsuario> optional = atividadeFilhoEscolhaUsuarioRepository.findById(dados.getIdAtividadeFilhoEscolhaUsuario());
		if(optional.isPresent()) {
			AtividadeFilhoEscolhaUsuario item = optional.get();
			
			if(!idUsuario.equals(item.getAtividadeFilhoUsuario().getUsuario().getId())) {
				throw new RuntimeException("Essa atividade não pertence ao seu usuário");
			}
			
			List<AtividadeFilhoEscolhaOpcaoUsuarioDto> opcoes = opcaoService.buscarPorAtividadeId(item, null);
			for(AtividadeFilhoEscolhaOpcaoUsuarioDto opcao : opcoes) {
				if(opcao.getId().equals(dados.getIdOpcaoEscolhida())) {
					item.setAcertou(opcao.getOpcaoCorreta());
					item.setStatus(StatusAtividadeFilhoItemEnum.FINALIZADA.getCodigo());
					opcaoService.marcarComoEscolhida(opcao.getId());
				}
			}
		}
		
	}
	
	@Transactional
	public void responder(AtividadeEscolhaDuasOpcoesResponderDto dados) {
		Long idUsuario = usuarioLogadoService.getUsuarioLogado().getId();
		
		Optional<AtividadeFilhoEscolhaUsuario> optional = atividadeFilhoEscolhaUsuarioRepository.findById(dados.getIdAtividadeFilhoEscolhaUsuario());
		if(optional.isPresent()) {
			AtividadeFilhoEscolhaUsuario item = optional.get();
			
			if(!idUsuario.equals(item.getAtividadeFilhoUsuario().getUsuario().getId())) {
				throw new RuntimeException("Essa atividade não pertence ao seu usuário");
			}
			int acertos = 0;
			List<AtividadeFilhoEscolhaOpcaoUsuarioDto> opcoes = opcaoService.buscarPorAtividadeId(item, null);
			for(AtividadeFilhoEscolhaOpcaoUsuarioDto opcao : opcoes) {
				for(Long idOpcaoEscolhida : dados.getIdOpcoesEscolhidas())
				if(opcao.getId().equals(idOpcaoEscolhida)) {
					if(opcao.getOpcaoCorreta()) {
						acertos++;
					}
					opcaoService.marcarComoEscolhida(opcao.getId());
				}
			}
			if(acertos == 2) {
				item.setAcertou(true);
				item.setStatus(StatusAtividadeFilhoItemEnum.FINALIZADA.getCodigo());
				
			}
		}
		
	}
	
	public Integer buscarNotaPorAtividade(Long idAtividadeUsuario) {
		List<AtividadeFilhoEscolhaUsuarioDto> itens = atividadeFilhoEscolhaUsuarioMapper.toDto(atividadeFilhoEscolhaUsuarioRepository.findAllByAtividadeFilhoUsuarioIdOrderBySequencial(idAtividadeUsuario));
		int nota = 0;
		for(AtividadeFilhoEscolhaUsuarioDto item : itens) {
			if(item.getAcertou()) {
				nota++;
			}
		}
		return nota;
	}
}

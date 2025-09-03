package br.app.alfabetizei.service.atividadeFilho;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.alfabetizei.dto.ImageDto;
import br.app.alfabetizei.dto.UsuarioDto;
import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoDto;
import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoUsuarioDto;
import br.app.alfabetizei.dto.atividadeFilho.responder.AtividadeContarSilabasResponderDto;
import br.app.alfabetizei.dto.atividadeFilho.responder.AtividadeEscolhaResponderDto;
import br.app.alfabetizei.dto.atividadeFilho.responder.AtividadeLetrasPontilhadasResponderDto;
import br.app.alfabetizei.enums.StatusAtividadeFilhoEnum;
import br.app.alfabetizei.enums.TipoAtividadeFilhoEnum;
import br.app.alfabetizei.mapper.atividadeFilho.AtividadeFilhoMapper;
import br.app.alfabetizei.mapper.atividadeFilho.AtividadeFilhoUsuarioMapper;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoUsuario;
import br.app.alfabetizei.repository.atividadeFilho.AtividadeFilhoRepository;
import br.app.alfabetizei.repository.atividadeFilho.AtividadeFilhoUsuarioRepository;
import br.app.alfabetizei.service.UsuarioLogadoService;
import br.app.alfabetizei.util.ImageUtil;
import jakarta.transaction.Transactional;

@Service
public class AtividadeFilhoService {
	
	@Autowired
	private AtividadeFilhoRepository repository;
	
	@Autowired
	private AtividadeFilhoMapper mapper;
	
	@Autowired
	private AtividadeFilhoUsuarioRepository atividadeUsuarioRepository;
	
	@Autowired
	private AtividadeFilhoUsuarioMapper atividadeUsuarioMapper;
	
	@Autowired
	private AtividadeFilhoDependenciaService atividadeDependenciaService;
	
	@Autowired
	private AtividadeFilhoEscolhaService escolhaService;
	
	@Autowired
	private AtividadeFilhoContarSilabasService contarSilabasService;
	
	@Autowired
	private AtividadeFilhoLetrasPontilhadasService letrasPontilhadasService;
	
	@Autowired
	private UsuarioLogadoService usuarioLogadoService;
	
	public List<AtividadeFilhoUsuarioDto> buscarAtividadesFilho(){
		Long idUsuario = usuarioLogadoService.getUsuarioLogado().getId();
		List<AtividadeFilhoDto> atividades = mapper.toDto(repository.findAll());
		
		List<AtividadeFilhoUsuarioDto> atividadesUsuario = new ArrayList<AtividadeFilhoUsuarioDto>();
		for(AtividadeFilhoDto atividadeFilho : atividades) {
			
			AtividadeFilhoUsuarioDto atividadeUsuario = atividadeUsuarioMapper.toDto(atividadeUsuarioRepository.getByAtividadeFilhoIdAndUsuarioId(atividadeFilho.getId(), idUsuario));
			
			if(atividadeUsuario == null) {
				atividadeUsuario = new AtividadeFilhoUsuarioDto();
				atividadeUsuario.setAtividadeFilho(atividadeFilho);
				atividadeUsuario.setUsuario(UsuarioDto.builder().id(idUsuario).build());
				atividadeUsuario.setStatus(atividadeDependenciaService.isAtividadeDesbloqueada(atividadeFilho.getId(), idUsuario)?StatusAtividadeFilhoEnum.LIBERADA:StatusAtividadeFilhoEnum.BLOQUEADA);		
			}
			
			atividadesUsuario.add(atividadeUsuario);
		}
		
		return atividadesUsuario;
	}
	
	

	public AtividadeFilhoUsuarioDto buscarAtividade(Long idAtividade) {
		Long idUsuario = usuarioLogadoService.getUsuarioLogado().getId();
		AtividadeFilhoUsuarioDto atividadeUsuarioDto = atividadeUsuarioMapper.toDto(atividadeUsuarioRepository.getByAtividadeFilhoIdAndUsuarioId(idAtividade, idUsuario));
		
		if(atividadeUsuarioDto == null) {
			atividadeUsuarioDto = new AtividadeFilhoUsuarioDto();
			atividadeUsuarioDto.setAtividadeFilho(mapper.toDto(repository.getReferenceById(idAtividade)));
			atividadeUsuarioDto.setUsuario(UsuarioDto.builder().id(idUsuario).build());
			atividadeUsuarioDto.setStatus(StatusAtividadeFilhoEnum.LIBERADA);
			atividadeUsuarioDto.setInicio(LocalDateTime.now());
			AtividadeFilhoUsuario atividadeUsuario = atividadeUsuarioMapper.toEntity(atividadeUsuarioDto);
			atividadeUsuario = atividadeUsuarioRepository.save(atividadeUsuario);
			
			atividadeUsuarioDto = atividadeUsuarioMapper.toDto(atividadeUsuario);
		}
		
		atividadeUsuarioDto.setItensLetrasPontilhadas(letrasPontilhadasService.buscarPorAtividade(atividadeUsuarioMapper.toEntity(atividadeUsuarioDto)));
		atividadeUsuarioDto.setItensEscolha(escolhaService.buscarPorAtividade(atividadeUsuarioMapper.toEntity(atividadeUsuarioDto)));
		atividadeUsuarioDto.setItensContarSilabas(contarSilabasService.buscarPorAtividade(atividadeUsuarioMapper.toEntity(atividadeUsuarioDto)));
		
		return atividadeUsuarioDto;
	}
	
	@Transactional
	public void responderItemLetrasPontilhadas(AtividadeLetrasPontilhadasResponderDto dados) {
		letrasPontilhadasService.responder(dados);
	}
	
	@Transactional
	public void responderItemEscolha(AtividadeEscolhaResponderDto dados) {
		escolhaService.responder(dados);
	}
	
	@Transactional
	public void responderItemContarSilabas(AtividadeContarSilabasResponderDto dados) {
		contarSilabasService.responder(dados);
	}
	
	@Transactional
	public AtividadeFilhoUsuarioDto finalizarAtividade(Long idAtividade) {
		Long idUsuario = usuarioLogadoService.getUsuarioLogado().getId();
		
		Optional<AtividadeFilhoUsuario> optional = atividadeUsuarioRepository.findById(idAtividade);
		if(optional.isPresent()) {
			AtividadeFilhoUsuario atividadeUsuario = optional.get();
			if(!idUsuario.equals(atividadeUsuario.getUsuario().getId())) {
				throw new RuntimeException("Essa atividade não pertence ao seu usuário");
			}
			atividadeUsuario.setFim(LocalDateTime.now());
			atividadeUsuario.setStatus(StatusAtividadeFilhoEnum.FINALIZADA.getCodigo());
			atividadeUsuario.setNota(getNotaByAtividade(atividadeUsuario));
			
			return atividadeUsuarioMapper.toDto(atividadeUsuario);
		}
		
		return null;
	}
	
	private Integer getNotaByAtividade(AtividadeFilhoUsuario atividadeUsuario) {
		if (atividadeUsuario.getAtividadeFilho().getTipo().equals(TipoAtividadeFilhoEnum.SILABAS.getCodigo())) {
			return contarSilabasService.buscarNotaPorAtividade(atividadeUsuario.getId());
		}
		if (atividadeUsuario.getAtividadeFilho().getTipo().equals(TipoAtividadeFilhoEnum.LETRAS_PONTILHADAS.getCodigo())) {
			return 5;
		}
		if (atividadeUsuario.getAtividadeFilho().getTipo().equals(TipoAtividadeFilhoEnum.MULTIPLA_ESCOLHA.getCodigo())) {
			return escolhaService.buscarNotaPorAtividade(atividadeUsuario.getId());
		}
		return 0;
	}



	public ImageDto buscarImagemOpcao(Long idAtividade, Long sequencial, Long sequencialOpcao) {
		return ImageUtil.getImage("images/atividade_filho/" + idAtividade + "/escolha_opcao/" + sequencial + "/" + sequencialOpcao);
	}
	public ImageDto buscarImagemContarSilabas(Long idAtividade, Long sequencial) {
		return ImageUtil.getImage("images/atividade_filho/" + idAtividade + "/contar_silabas/" + sequencial);
	}
}

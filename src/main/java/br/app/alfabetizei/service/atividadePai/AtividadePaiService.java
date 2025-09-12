package br.app.alfabetizei.service.atividadePai;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.alfabetizei.dto.ImageDto;
import br.app.alfabetizei.dto.UsuarioDto;
import br.app.alfabetizei.dto.atividadePai.AtividadePaiDto;
import br.app.alfabetizei.dto.atividadePai.AtividadePaiResumoDto;
import br.app.alfabetizei.dto.atividadePai.AtividadePaiUsuarioDto;
import br.app.alfabetizei.enums.StatusAtividadePaiEnum;
import br.app.alfabetizei.mapper.atividadePai.AtividadePaiMapper;
import br.app.alfabetizei.mapper.atividadePai.AtividadePaiUsuarioMapper;
import br.app.alfabetizei.model.atividadePai.AtividadePaiUsuario;
import br.app.alfabetizei.repository.atividadePai.AtividadePaiRepository;
import br.app.alfabetizei.repository.atividadePai.AtividadePaiUsuarioRepository;
import br.app.alfabetizei.service.UsuarioLogadoService;
import br.app.alfabetizei.util.ImageUtil;
import jakarta.transaction.Transactional;

@Service
public class AtividadePaiService {
	@Autowired
	private AtividadePaiRepository repository;
	
	@Autowired
	private AtividadePaiMapper mapper;
	
	@Autowired
	private AtividadePaiUsuarioRepository atividadeUsuarioRepository;
	
	@Autowired
	private AtividadePaiUsuarioMapper atividadeUsuarioMapper;
	
	@Autowired
	private UsuarioLogadoService usuarioLogadoService;
	
	@Autowired
	private AtividadePaiDependenciaService atividadeDependenciaService;
	
	@Autowired
	private AtividadePaiTextoService textoService;
	
	@Autowired
	private AtividadePaiSugestaoLeituraService sugestaoLeituraService;
	
	@Autowired
	private AtividadePaiSugestaoVideoService sugestaoVideoService;
	
	public List<AtividadePaiUsuarioDto> buscarAtividadesPai(){
		Long idUsuario = usuarioLogadoService.getUsuarioLogado().getId();
		
		List<AtividadePaiDto> atividades = mapper.toDto(repository.findAll());
		
		List<AtividadePaiUsuarioDto> atividadesUsuario = new ArrayList<AtividadePaiUsuarioDto>();
		for(AtividadePaiDto atividadePai : atividades) {
			
			AtividadePaiUsuarioDto atividadeUsuario = atividadeUsuarioMapper.toDto(atividadeUsuarioRepository.getByAtividadePaiIdAndUsuarioId(atividadePai.getId(), idUsuario));
			
			if(atividadeUsuario == null) {
				atividadeUsuario = new AtividadePaiUsuarioDto();
				atividadeUsuario.setAtividadePai(atividadePai);
				atividadeUsuario.setUsuario(UsuarioDto.builder().id(idUsuario).build());
				atividadeUsuario.setStatus(atividadeDependenciaService.isAtividadeDesbloqueada(atividadePai.getId(), idUsuario)?StatusAtividadePaiEnum.LIBERADA:StatusAtividadePaiEnum.BLOQUEADA);		
				AtividadePaiUsuario atividadeUsuarioSalvo = atividadeUsuarioRepository.save(atividadeUsuarioMapper.toEntity(atividadeUsuario));
				atividadeUsuario.setId(atividadeUsuarioSalvo.getId());
				
			}else {
				if(!atividadeUsuario.getStatus().equals(StatusAtividadePaiEnum.FINALIZADA)) {
					atividadeUsuario.setStatus(atividadeDependenciaService.isAtividadeDesbloqueada(atividadePai.getId(), idUsuario)?StatusAtividadePaiEnum.LIBERADA:StatusAtividadePaiEnum.BLOQUEADA);			
				}
				
			}
			
			atividadesUsuario.add(atividadeUsuario);
		}
		
		atividadesUsuario.sort((atividadeAnterior, atividade)->{
			if(atividadeAnterior.getStatus().equals(StatusAtividadePaiEnum.LIBERADA) && atividade.getStatus().equals(StatusAtividadePaiEnum.BLOQUEADA)) {
				return -1;
			} else if(atividade.getStatus().equals(StatusAtividadePaiEnum.LIBERADA) && atividadeAnterior.getStatus().equals(StatusAtividadePaiEnum.BLOQUEADA)) {
				return 1;
			}
			if(atividadeAnterior.getStatus().equals(StatusAtividadePaiEnum.FINALIZADA)&& (atividade.getStatus().equals(StatusAtividadePaiEnum.BLOQUEADA) || atividade.getStatus().equals(StatusAtividadePaiEnum.LIBERADA))) {
				return 1;
			}
			if(atividade.getStatus().equals(StatusAtividadePaiEnum.FINALIZADA)&& (atividadeAnterior.getStatus().equals(StatusAtividadePaiEnum.BLOQUEADA) || atividadeAnterior.getStatus().equals(StatusAtividadePaiEnum.LIBERADA))) {
				return -1;
			}
			return 0;
		});
		
		return atividadesUsuario;
	}
	
	
	@Transactional
	public AtividadePaiUsuarioDto buscarAtividade(Long idAtividade) {
		Long idUsuario = usuarioLogadoService.getUsuarioLogado().getId();
		AtividadePaiUsuarioDto atividadeUsuarioDto = atividadeUsuarioMapper.toDto(atividadeUsuarioRepository.getByAtividadePaiIdAndUsuarioId(idAtividade, idUsuario));
		
		if(atividadeUsuarioDto == null) {
			atividadeUsuarioDto = new AtividadePaiUsuarioDto();
			atividadeUsuarioDto.setAtividadePai(mapper.toDto(repository.getReferenceById(idAtividade)));
			atividadeUsuarioDto.setUsuario(UsuarioDto.builder().id(idUsuario).build());
			atividadeUsuarioDto.setStatus(StatusAtividadePaiEnum.LIBERADA);
			AtividadePaiUsuario atividadeUsuario = atividadeUsuarioMapper.toEntity(atividadeUsuarioDto);
			atividadeUsuario = atividadeUsuarioRepository.save(atividadeUsuario);
			
			atividadeUsuarioDto = atividadeUsuarioMapper.toDto(atividadeUsuario);
		}
		atividadeUsuarioDto.getAtividadePai().setItensLeitura(sugestaoLeituraService.buscarPorAtividadeId(idAtividade));
		atividadeUsuarioDto.getAtividadePai().setItensTexto(textoService.buscarPorAtividadeId(idAtividade));
		atividadeUsuarioDto.getAtividadePai().setItensVideo(sugestaoVideoService.buscarPorAtividadeId(idAtividade));
		
		
		return atividadeUsuarioDto;
	}
	
	@Transactional
	public void marcarComoFeito(Long idAtividade) {
		Long idUsuario = usuarioLogadoService.getUsuarioLogado().getId();
		
		AtividadePaiUsuario atividade = atividadeUsuarioRepository.getByAtividadePaiIdAndUsuarioId(idAtividade, idUsuario);
		if(atividade != null) {
			atividade.setStatus(StatusAtividadePaiEnum.FINALIZADA.getCodigo());
		}
	}

	public ImageDto getImage(Long idAtividade, Integer sequencial) {
		return ImageUtil.getImage("images/atividade_pai/" + idAtividade + "/" + sequencial);
	}


	public AtividadePaiResumoDto buscarResumo() {
		return AtividadePaiResumoDto.builder()
				.numeroDeAtividades(repository.count())
				.atividadesRealizadas(atividadeUsuarioRepository.countByUsuarioIdAndFinalizada(usuarioLogadoService.getUsuarioLogado().getId()))
				.build();
	}
}

package br.app.alfabetizei.service.atividadePai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoUsuarioDto;
import br.app.alfabetizei.dto.atividadePai.AtividadePaiDependenciaDto;
import br.app.alfabetizei.dto.atividadePai.AtividadePaiUsuarioDto;
import br.app.alfabetizei.enums.StatusAtividadeFilhoEnum;
import br.app.alfabetizei.enums.StatusAtividadePaiEnum;
import br.app.alfabetizei.mapper.atividadeFilho.AtividadeFilhoUsuarioMapper;
import br.app.alfabetizei.mapper.atividadePai.AtividadePaiDependenciaMapper;
import br.app.alfabetizei.mapper.atividadePai.AtividadePaiUsuarioMapper;
import br.app.alfabetizei.repository.atividadeFilho.AtividadeFilhoUsuarioRepository;
import br.app.alfabetizei.repository.atividadePai.AtividadePaiDependenciaRepository;
import br.app.alfabetizei.repository.atividadePai.AtividadePaiUsuarioRepository;

@Service
public class AtividadePaiDependenciaService {
	
	@Autowired
	private AtividadeFilhoUsuarioRepository atividadeFilhoUsuarioRepository;
	
	@Autowired
	private AtividadeFilhoUsuarioMapper atividadeFilhoUsuarioMapper;
	
	@Autowired
	private AtividadePaiDependenciaRepository atividadeDependenciaRepository;
	
	@Autowired
	private AtividadePaiDependenciaMapper atividadePaiDependenciaMapper;
	
	@Autowired
	private AtividadePaiUsuarioRepository atividadePaiUsuarioRepository;
	
	@Autowired
	private AtividadePaiUsuarioMapper atividadeUsuarioMapper;
	
	public boolean isAtividadeDesbloqueada(Long idAtividadePai, Long idUsuario) {
		List<AtividadePaiDependenciaDto> dependencias = atividadePaiDependenciaMapper.toDto(atividadeDependenciaRepository.findAllByAtividadePaiId(idAtividadePai));
		for(AtividadePaiDependenciaDto dependencia : dependencias) {
			if(dependencia.getAtividadeFilhoPredecessora()!=null) {
				AtividadeFilhoUsuarioDto atividade = atividadeFilhoUsuarioMapper.toDto(atividadeFilhoUsuarioRepository.getByAtividadeFilhoIdAndUsuarioId(dependencia.getAtividadeFilhoPredecessora().getId(), idUsuario));
				if(atividade == null) {
					return false;
				}
				if(!atividade.getStatus().equals(StatusAtividadeFilhoEnum.FINALIZADA)) {
					return false;
				}
			}
			
			if(dependencia.getAtividadePaiPredecessora()!=null) {
				AtividadePaiUsuarioDto atividade = atividadeUsuarioMapper.toDto(atividadePaiUsuarioRepository.getByAtividadePaiIdAndUsuarioId(dependencia.getAtividadePaiPredecessora().getId(), idUsuario));
				if(atividade == null) {
					return false;
				}
				if(!atividade.getStatus().equals(StatusAtividadePaiEnum.FINALIZADA)) {
					return false;
				}
			}
		}
		return true;
	}
}

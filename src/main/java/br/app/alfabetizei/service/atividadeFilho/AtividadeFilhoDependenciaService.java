package br.app.alfabetizei.service.atividadeFilho;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoDependenciaDto;
import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoUsuarioDto;
import br.app.alfabetizei.dto.atividadePai.AtividadePaiUsuarioDto;
import br.app.alfabetizei.enums.StatusAtividadeFilhoEnum;
import br.app.alfabetizei.enums.StatusAtividadePaiEnum;
import br.app.alfabetizei.mapper.atividadeFilho.AtividadeFilhoDependenciaMapper;
import br.app.alfabetizei.mapper.atividadeFilho.AtividadeFilhoUsuarioMapper;
import br.app.alfabetizei.mapper.atividadePai.AtividadePaiUsuarioMapper;
import br.app.alfabetizei.repository.atividadeFilho.AtividadeFilhoDependenciaRepository;
import br.app.alfabetizei.repository.atividadeFilho.AtividadeFilhoUsuarioRepository;
import br.app.alfabetizei.repository.atividadePai.AtividadePaiUsuarioRepository;

@Service
public class AtividadeFilhoDependenciaService {
	
	@Autowired
	private AtividadeFilhoDependenciaRepository atividadeDependenciaRepository;
	
	@Autowired
	private AtividadeFilhoDependenciaMapper atividadeDependenciaMapper;
	
	@Autowired
	private AtividadePaiUsuarioRepository atividadePaiUsuarioRepository;
	
	@Autowired
	private AtividadePaiUsuarioMapper atividadePaiUsuarioMapper;
	
	@Autowired
	private AtividadeFilhoUsuarioRepository atividadeFilhoUsuarioRepository;
	
	@Autowired
	private AtividadeFilhoUsuarioMapper atividadeFilhoUsuarioMapper;
	
	public boolean isAtividadeDesbloqueada(Long idAtividade, Long idUsuario) {
		List<AtividadeFilhoDependenciaDto> dependencias = atividadeDependenciaMapper.toDto(atividadeDependenciaRepository.findAllByAtividadeFilhoId(idAtividade));
		for(AtividadeFilhoDependenciaDto dependencia : dependencias) {
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
				AtividadePaiUsuarioDto atividade = atividadePaiUsuarioMapper.toDto(atividadePaiUsuarioRepository.getByAtividadePaiIdAndUsuarioId(dependencia.getAtividadePaiPredecessora().getId(), idUsuario));
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

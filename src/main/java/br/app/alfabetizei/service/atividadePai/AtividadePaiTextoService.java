package br.app.alfabetizei.service.atividadePai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.alfabetizei.dto.atividadePai.AtividadePaiTextoDto;
import br.app.alfabetizei.mapper.atividadePai.AtividadePaiTextoMapper;
import br.app.alfabetizei.repository.atividadePai.AtividadePaiTextoRepository;

@Service
public class AtividadePaiTextoService {
	
	@Autowired
	private AtividadePaiTextoRepository repository;
	
	@Autowired
	private AtividadePaiTextoMapper mapper;
	
	public List<AtividadePaiTextoDto> buscarPorAtividadeId(Long idAtividade){
		return mapper.toDto(repository.findAllByAtividadePaiId(idAtividade));
	}
	
}

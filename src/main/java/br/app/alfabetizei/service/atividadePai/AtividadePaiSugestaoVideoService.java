package br.app.alfabetizei.service.atividadePai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.alfabetizei.dto.atividadePai.AtividadePaiSugestaoVideoDto;
import br.app.alfabetizei.mapper.atividadePai.AtividadePaiSugestaoVideoMapper;
import br.app.alfabetizei.repository.atividadePai.AtividadePaiSugestaoVideoRepository;


@Service
public class AtividadePaiSugestaoVideoService {
	
	@Autowired
	private AtividadePaiSugestaoVideoRepository repository;
	
	@Autowired
	private AtividadePaiSugestaoVideoMapper mapper;
	
	public List<AtividadePaiSugestaoVideoDto> buscarPorAtividadeId(Long idAtividade){
		return mapper.toDto(repository.findAllByAtividadePaiId(idAtividade));
	}
	
}

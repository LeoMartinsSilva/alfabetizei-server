package br.app.alfabetizei.service.atividadePai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.alfabetizei.dto.atividadePai.AtividadePaiSugestaoLeituraDto;
import br.app.alfabetizei.mapper.atividadePai.AtividadePaiSugestaoLeituraMapper;
import br.app.alfabetizei.repository.atividadePai.AtividadePaiSugestaoLeituraRepository;


@Service
public class AtividadePaiSugestaoLeituraService {
	
	@Autowired
	private AtividadePaiSugestaoLeituraRepository repository;
	
	@Autowired
	private AtividadePaiSugestaoLeituraMapper mapper;
	
	public List<AtividadePaiSugestaoLeituraDto> buscarPorAtividadeId(Long idAtividade){
		return mapper.toDto(repository.findAllByAtividadePaiId(idAtividade));
	}
	
}

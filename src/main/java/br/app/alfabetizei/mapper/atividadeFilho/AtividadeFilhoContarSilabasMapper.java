package br.app.alfabetizei.mapper.atividadeFilho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoContarSilabasDto;
import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoContarSilabasDto.AtividadeFilhoContarSilabasDtoBuilder;
import br.app.alfabetizei.mapper.AbstractMapper;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoContarSilabas;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoContarSilabas.AtividadeFilhoContarSilabasBuilder;

@ComponentScan
@Component
public class AtividadeFilhoContarSilabasMapper extends AbstractMapper<AtividadeFilhoContarSilabasDto, AtividadeFilhoContarSilabas> {
	
	@Autowired
	private AtividadeFilhoMapper atividadeFilhoMapper;
	
    @Override
    public AtividadeFilhoContarSilabasDto toDto(AtividadeFilhoContarSilabas entity) {
    	
    	AtividadeFilhoContarSilabasDtoBuilder builder = AtividadeFilhoContarSilabasDto.builder()
                .id(entity.getId())
                .atividadeFilho(entity.getAtividadeFilho()!=null? atividadeFilhoMapper.toDto(entity.getAtividadeFilho()) :null)
                .sequencial(entity.getSequencial())
                .palavra(entity.getPalavra())
                .numeroSilabas(entity.getNumeroSilabas());

        return builder.build();
    }

    @Override
    public AtividadeFilhoContarSilabas toEntity(AtividadeFilhoContarSilabasDto dto) {

    	AtividadeFilhoContarSilabasBuilder builder = AtividadeFilhoContarSilabas.builder()
    			.id(dto.getId())
                .atividadeFilho(dto.getAtividadeFilho()!=null? atividadeFilhoMapper.toEntity(dto.getAtividadeFilho()) :null)
                .sequencial(dto.getSequencial())
                .palavra(dto.getPalavra())
                .numeroSilabas(dto.getNumeroSilabas());
    	
         return builder.build();
    }

}

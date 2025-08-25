package br.app.alfabetizei.mapper.atividadePai;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.app.alfabetizei.dto.atividadePai.AtividadePaiDto;
import br.app.alfabetizei.dto.atividadePai.AtividadePaiDto.AtividadePaiDtoBuilder;
import br.app.alfabetizei.enums.TipoAtividadePaiEnum;
import br.app.alfabetizei.mapper.AbstractMapper;
import br.app.alfabetizei.model.atividadePai.AtividadePai;
import br.app.alfabetizei.model.atividadePai.AtividadePai.AtividadePaiBuilder;

@ComponentScan
@Component
public class AtividadePaiMapper extends AbstractMapper<AtividadePaiDto, AtividadePai> {
	
    @Override
    public AtividadePaiDto toDto(AtividadePai entity) {
    	
    	AtividadePaiDtoBuilder builder = AtividadePaiDto.builder()
                .id(entity.getId())
                .titulo(entity.getTitulo())
                .subtitulo(entity.getSubtitulo())
                .tipo(TipoAtividadePaiEnum.getEnum(entity.getTipo()));

        return builder.build();
    }

    @Override
    public AtividadePai toEntity(AtividadePaiDto dto) {

    	AtividadePaiBuilder builder = AtividadePai.builder()
                .id(dto.getId())
                .titulo(dto.getTitulo())
                .subtitulo(dto.getSubtitulo())
                .tipo(dto.getTipo().getCodigo());
    	
         return builder.build();
    }

}

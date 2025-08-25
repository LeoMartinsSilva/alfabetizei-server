package br.app.alfabetizei.mapper.atividadeFilho;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoDto;
import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoDto.AtividadeFilhoDtoBuilder;
import br.app.alfabetizei.enums.TipoAtividadeFilhoEnum;
import br.app.alfabetizei.mapper.AbstractMapper;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilho;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilho.AtividadeFilhoBuilder;

@ComponentScan
@Component
public class AtividadeFilhoMapper extends AbstractMapper<AtividadeFilhoDto, AtividadeFilho> {
	
    @Override
    public AtividadeFilhoDto toDto(AtividadeFilho entity) {
    	
    	AtividadeFilhoDtoBuilder builder = AtividadeFilhoDto.builder()
                .id(entity.getId())
                .titulo(entity.getTitulo())
                .subtitulo(entity.getSubtitulo())
                .tipo(TipoAtividadeFilhoEnum.getEnum(entity.getTipo()));

        return builder.build();
    }

    @Override
    public AtividadeFilho toEntity(AtividadeFilhoDto dto) {

    	AtividadeFilhoBuilder builder = AtividadeFilho.builder()
                .id(dto.getId())
                .titulo(dto.getTitulo())
                .subtitulo(dto.getSubtitulo())
                .tipo(dto.getTipo().getCodigo());
    	
         return builder.build();
    }

}

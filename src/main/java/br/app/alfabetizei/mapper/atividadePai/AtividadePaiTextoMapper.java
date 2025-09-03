package br.app.alfabetizei.mapper.atividadePai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.app.alfabetizei.dto.atividadePai.AtividadePaiTextoDto.AtividadePaiTextoDtoBuilder;
import br.app.alfabetizei.dto.atividadePai.AtividadePaiTextoDto;
import br.app.alfabetizei.mapper.AbstractMapper;
import br.app.alfabetizei.model.atividadePai.AtividadePaiTexto.AtividadePaiTextoBuilder;
import br.app.alfabetizei.model.atividadePai.AtividadePaiTexto;

@ComponentScan
@Component
public class AtividadePaiTextoMapper extends AbstractMapper<AtividadePaiTextoDto, AtividadePaiTexto> {
	
	@Autowired
	private AtividadePaiMapper atividadePaiMapper;
	
    @Override
    public AtividadePaiTextoDto toDto(AtividadePaiTexto entity) {
    	
    	AtividadePaiTextoDtoBuilder builder = AtividadePaiTextoDto.builder()
                .id(entity.getId())
                .atividadePai(entity.getAtividadePai()!=null?atividadePaiMapper.toDto(entity.getAtividadePai()):null)
                .sequencial(entity.getSequencial())
                .titulo(entity.getTitulo())
                .texto(entity.getTexto())
                .temImagem(entity.getTemImagem());

        return builder.build();
    }

    @Override
    public AtividadePaiTexto toEntity(AtividadePaiTextoDto dto) {

    	AtividadePaiTextoBuilder builder = AtividadePaiTexto.builder()
    			.id(dto.getId())
                .atividadePai(dto.getAtividadePai()!=null?atividadePaiMapper.toEntity(dto.getAtividadePai()):null)
                .sequencial(dto.getSequencial())
                .titulo(dto.getTitulo())
                .texto(dto.getTexto())
                .temImagem(dto.getTemImagem());
    	
         return builder.build();
    }

}

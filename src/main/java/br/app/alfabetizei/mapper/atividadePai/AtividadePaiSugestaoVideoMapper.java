package br.app.alfabetizei.mapper.atividadePai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.app.alfabetizei.dto.atividadePai.AtividadePaiSugestaoVideoDto.AtividadePaiSugestaoVideoDtoBuilder;
import br.app.alfabetizei.dto.atividadePai.AtividadePaiSugestaoVideoDto;
import br.app.alfabetizei.mapper.AbstractMapper;
import br.app.alfabetizei.model.atividadePai.AtividadePaiSugestaoVideo.AtividadePaiSugestaoVideoBuilder;
import br.app.alfabetizei.model.atividadePai.AtividadePaiSugestaoVideo;

@ComponentScan
@Component
public class AtividadePaiSugestaoVideoMapper extends AbstractMapper<AtividadePaiSugestaoVideoDto, AtividadePaiSugestaoVideo> {
	
	@Autowired
	private AtividadePaiMapper atividadePaiMapper;
	
    @Override
    public AtividadePaiSugestaoVideoDto toDto(AtividadePaiSugestaoVideo entity) {
    	
    	AtividadePaiSugestaoVideoDtoBuilder builder = AtividadePaiSugestaoVideoDto.builder()
                .id(entity.getId())
                .atividadePai(entity.getAtividadePai()!=null?atividadePaiMapper.toDto(entity.getAtividadePai()):null)
                .sequencial(entity.getSequencial())
                .titulo(entity.getTitulo())
                .descricao(entity.getDescricao());

        return builder.build();
    }

    @Override
    public AtividadePaiSugestaoVideo toEntity(AtividadePaiSugestaoVideoDto dto) {

    	AtividadePaiSugestaoVideoBuilder builder = AtividadePaiSugestaoVideo.builder()
    			.id(dto.getId())
                .atividadePai(dto.getAtividadePai()!=null?atividadePaiMapper.toEntity(dto.getAtividadePai()):null)
                .sequencial(dto.getSequencial())
                .titulo(dto.getTitulo())
                .descricao(dto.getDescricao());
    	
         return builder.build();
    }

}

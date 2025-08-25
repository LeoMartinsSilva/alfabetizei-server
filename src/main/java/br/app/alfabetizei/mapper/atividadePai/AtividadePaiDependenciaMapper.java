package br.app.alfabetizei.mapper.atividadePai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.app.alfabetizei.dto.atividadePai.AtividadePaiDependenciaDto;
import br.app.alfabetizei.dto.atividadePai.AtividadePaiDependenciaDto.AtividadePaiDependenciaDtoBuilder;
import br.app.alfabetizei.mapper.AbstractMapper;
import br.app.alfabetizei.mapper.atividadeFilho.AtividadeFilhoMapper;
import br.app.alfabetizei.model.atividadePai.AtividadePaiDependencia;
import br.app.alfabetizei.model.atividadePai.AtividadePaiDependencia.AtividadePaiDependenciaBuilder;

@ComponentScan
@Component
public class AtividadePaiDependenciaMapper extends AbstractMapper<AtividadePaiDependenciaDto, AtividadePaiDependencia> {
	
	@Autowired
	private AtividadeFilhoMapper atividadeFilhoMapper;
	
	@Autowired
	private AtividadePaiMapper atividadePaiMapper;
	
    @Override
    public AtividadePaiDependenciaDto toDto(AtividadePaiDependencia entity) {
    	
    	AtividadePaiDependenciaDtoBuilder builder = AtividadePaiDependenciaDto.builder()
                .id(entity.getId())
                .atividadePai(entity.getAtividadePai()!=null? atividadePaiMapper.toDto(entity.getAtividadePai()) :null)
                .atividadeFilhoPredecessora(entity.getAtividadeFilhoPredecessora()!=null?atividadeFilhoMapper.toDto(entity.getAtividadeFilhoPredecessora()):null)
                .atividadePaiPredecessora(entity.getAtividadePaiPredecessora()!=null?atividadePaiMapper.toDto(entity.getAtividadePaiPredecessora()):null);
                
        return builder.build();
    }

    @Override
    public AtividadePaiDependencia toEntity(AtividadePaiDependenciaDto dto) {

    	AtividadePaiDependenciaBuilder builder = AtividadePaiDependencia.builder()
    			.id(dto.getId())
                .atividadePai(dto.getAtividadePai()!=null? atividadePaiMapper.toEntity(dto.getAtividadePai()) :null)
                .atividadeFilhoPredecessora(dto.getAtividadeFilhoPredecessora()!=null?atividadeFilhoMapper.toEntity(dto.getAtividadeFilhoPredecessora()):null)
                .atividadePaiPredecessora(dto.getAtividadePaiPredecessora()!=null?atividadePaiMapper.toEntity(dto.getAtividadePaiPredecessora()):null);
                
         return builder.build();
    }

}

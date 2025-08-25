package br.app.alfabetizei.mapper.atividadeFilho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoDependenciaDto;
import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoDependenciaDto.AtividadeFilhoDependenciaDtoBuilder;
import br.app.alfabetizei.mapper.AbstractMapper;
import br.app.alfabetizei.mapper.atividadePai.AtividadePaiMapper;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoDependencia;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoDependencia.AtividadeFilhoDependenciaBuilder;

@ComponentScan
@Component
public class AtividadeFilhoDependenciaMapper extends AbstractMapper<AtividadeFilhoDependenciaDto, AtividadeFilhoDependencia> {
	
	@Autowired
	private AtividadeFilhoMapper atividadeFilhoMapper;
	
	@Autowired
	private AtividadePaiMapper atividadePaiMapper;
	
    @Override
    public AtividadeFilhoDependenciaDto toDto(AtividadeFilhoDependencia entity) {
    	
    	AtividadeFilhoDependenciaDtoBuilder builder = AtividadeFilhoDependenciaDto.builder()
                .id(entity.getId())
                .atividadeFilho(entity.getAtividadeFilho()!=null? atividadeFilhoMapper.toDto(entity.getAtividadeFilho()) :null)
                .atividadeFilhoPredecessora(entity.getAtividadeFilhoPredecessora()!=null?atividadeFilhoMapper.toDto(entity.getAtividadeFilhoPredecessora()):null)
                .atividadePaiPredecessora(entity.getAtividadePaiPredecessora()!=null?atividadePaiMapper.toDto(entity.getAtividadePaiPredecessora()):null);
                
        return builder.build();
    }

    @Override
    public AtividadeFilhoDependencia toEntity(AtividadeFilhoDependenciaDto dto) {

    	AtividadeFilhoDependenciaBuilder builder = AtividadeFilhoDependencia.builder()
    			.id(dto.getId())
                .atividadeFilho(dto.getAtividadeFilho()!=null? atividadeFilhoMapper.toEntity(dto.getAtividadeFilho()) :null)
                .atividadeFilhoPredecessora(dto.getAtividadeFilhoPredecessora()!=null?atividadeFilhoMapper.toEntity(dto.getAtividadeFilhoPredecessora()):null)
                .atividadePaiPredecessora(dto.getAtividadePaiPredecessora()!=null?atividadePaiMapper.toEntity(dto.getAtividadePaiPredecessora()):null);
                
         return builder.build();
    }

}

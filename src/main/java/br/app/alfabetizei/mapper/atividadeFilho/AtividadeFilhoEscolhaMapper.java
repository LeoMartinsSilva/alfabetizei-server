package br.app.alfabetizei.mapper.atividadeFilho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoEscolhaDto;
import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoEscolhaDto.AtividadeFilhoEscolhaDtoBuilder;
import br.app.alfabetizei.mapper.AbstractMapper;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoEscolha;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoEscolha.AtividadeFilhoEscolhaBuilder;

@ComponentScan
@Component
public class AtividadeFilhoEscolhaMapper extends AbstractMapper<AtividadeFilhoEscolhaDto, AtividadeFilhoEscolha> {
	
	@Autowired
	private AtividadeFilhoMapper atividadeFilhoMapper;
	
    @Override
    public AtividadeFilhoEscolhaDto toDto(AtividadeFilhoEscolha entity) {
    	
    	AtividadeFilhoEscolhaDtoBuilder builder = AtividadeFilhoEscolhaDto.builder()
                .id(entity.getId())
                .atividadeFilho(entity.getAtividadeFilho()!=null? atividadeFilhoMapper.toDto(entity.getAtividadeFilho()) :null)
                .sequencial(entity.getSequencial());

        return builder.build();
    }

    @Override
    public AtividadeFilhoEscolha toEntity(AtividadeFilhoEscolhaDto dto) {

    	AtividadeFilhoEscolhaBuilder builder = AtividadeFilhoEscolha.builder()
    			.id(dto.getId())
                .atividadeFilho(dto.getAtividadeFilho()!=null? atividadeFilhoMapper.toEntity(dto.getAtividadeFilho()) :null)
                .sequencial(dto.getSequencial());
    	
         return builder.build();
    }

}

package br.app.alfabetizei.mapper.atividadeFilho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoEscolhaOpcaoDto;
import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoEscolhaOpcaoDto.AtividadeFilhoEscolhaOpcaoDtoBuilder;
import br.app.alfabetizei.mapper.AbstractMapper;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoEscolhaOpcao;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoEscolhaOpcao.AtividadeFilhoEscolhaOpcaoBuilder;

@ComponentScan
@Component
public class AtividadeFilhoEscolhaOpcaoMapper extends AbstractMapper<AtividadeFilhoEscolhaOpcaoDto, AtividadeFilhoEscolhaOpcao> {
	
	@Autowired
	private AtividadeFilhoEscolhaMapper atividadeFilhoEscolhaMapper;
	
    @Override
    public AtividadeFilhoEscolhaOpcaoDto toDto(AtividadeFilhoEscolhaOpcao entity) {
    	
    	AtividadeFilhoEscolhaOpcaoDtoBuilder builder = AtividadeFilhoEscolhaOpcaoDto.builder()
                .id(entity.getId())
                .atividadeFilhoEscolha(entity.getAtividadeFilhoEscolha()!=null? atividadeFilhoEscolhaMapper.toDto(entity.getAtividadeFilhoEscolha()) :null)
                .sequencial(entity.getSequencial())
                .descricao(entity.getDescricao())
                .opcaoCorreta(entity.getOpcaoCorreta());

        return builder.build();
    }

    @Override
    public AtividadeFilhoEscolhaOpcao toEntity(AtividadeFilhoEscolhaOpcaoDto dto) {

    	AtividadeFilhoEscolhaOpcaoBuilder builder = AtividadeFilhoEscolhaOpcao.builder()
    			.id(dto.getId())
                .atividadeFilhoEscolha(dto.getAtividadeFilhoEscolha()!=null? atividadeFilhoEscolhaMapper.toEntity(dto.getAtividadeFilhoEscolha()) :null)
                .sequencial(dto.getSequencial())
                .descricao(dto.getDescricao())
                .opcaoCorreta(dto.getOpcaoCorreta());
    	
         return builder.build();
    }

}

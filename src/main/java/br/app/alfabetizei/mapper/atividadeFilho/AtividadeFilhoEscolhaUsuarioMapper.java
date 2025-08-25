package br.app.alfabetizei.mapper.atividadeFilho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoEscolhaUsuarioDto;
import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoEscolhaUsuarioDto.AtividadeFilhoEscolhaUsuarioDtoBuilder;
import br.app.alfabetizei.enums.StatusAtividadeFilhoItemEnum;
import br.app.alfabetizei.mapper.AbstractMapper;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoEscolhaUsuario;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoEscolhaUsuario.AtividadeFilhoEscolhaUsuarioBuilder;

@ComponentScan
@Component
public class AtividadeFilhoEscolhaUsuarioMapper extends AbstractMapper<AtividadeFilhoEscolhaUsuarioDto, AtividadeFilhoEscolhaUsuario> {
	
	@Autowired
	private AtividadeFilhoUsuarioMapper atividadeFilhoUsuarioMapper;
	
    @Override
    public AtividadeFilhoEscolhaUsuarioDto toDto(AtividadeFilhoEscolhaUsuario entity) {
    	
    	AtividadeFilhoEscolhaUsuarioDtoBuilder builder = AtividadeFilhoEscolhaUsuarioDto.builder()
                .id(entity.getId())
                .atividadeFilhoUsuario(entity.getAtividadeFilhoUsuario()!=null? atividadeFilhoUsuarioMapper.toDto(entity.getAtividadeFilhoUsuario()) :null)
                .sequencial(entity.getSequencial())
                .acertou(entity.getAcertou())
                .status(StatusAtividadeFilhoItemEnum.getEnum(entity.getStatus()));

        return builder.build();
    }

    @Override
    public AtividadeFilhoEscolhaUsuario toEntity(AtividadeFilhoEscolhaUsuarioDto dto) {

    	AtividadeFilhoEscolhaUsuarioBuilder builder = AtividadeFilhoEscolhaUsuario.builder()
    			.id(dto.getId())
                .atividadeFilhoUsuario(dto.getAtividadeFilhoUsuario()!=null? atividadeFilhoUsuarioMapper.toEntity(dto.getAtividadeFilhoUsuario()) :null)
                .sequencial(dto.getSequencial())
                .acertou(dto.getAcertou())
                .status(dto.getStatus().getCodigo());
    	
         return builder.build();
    }

}

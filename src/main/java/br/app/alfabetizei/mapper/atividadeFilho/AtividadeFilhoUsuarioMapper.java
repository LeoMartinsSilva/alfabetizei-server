package br.app.alfabetizei.mapper.atividadeFilho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoUsuarioDto;
import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoUsuarioDto.AtividadeFilhoUsuarioDtoBuilder;
import br.app.alfabetizei.enums.StatusAtividadeFilhoEnum;
import br.app.alfabetizei.mapper.AbstractMapper;
import br.app.alfabetizei.mapper.UsuarioMapper;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoUsuario;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoUsuario.AtividadeFilhoUsuarioBuilder;

@ComponentScan
@Component
public class AtividadeFilhoUsuarioMapper extends AbstractMapper<AtividadeFilhoUsuarioDto, AtividadeFilhoUsuario> {
	
	@Autowired
	private AtividadeFilhoMapper atividadeFilhoMapper;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
    @Override
    public AtividadeFilhoUsuarioDto toDto(AtividadeFilhoUsuario entity) {
    	
    	AtividadeFilhoUsuarioDtoBuilder builder = AtividadeFilhoUsuarioDto.builder()
                .id(entity.getId())
                .atividadeFilho(entity.getAtividadeFilho()!=null? atividadeFilhoMapper.toDto(entity.getAtividadeFilho()) :null)
                .usuario(entity.getUsuario()!=null? usuarioMapper.toDto(entity.getUsuario()) :null)
                .inicio(entity.getInicio())
                .fim(entity.getFim())
                .status(StatusAtividadeFilhoEnum.getEnum(entity.getStatus()))
                .nota(entity.getNota());

        return builder.build();
    }

    @Override
    public AtividadeFilhoUsuario toEntity(AtividadeFilhoUsuarioDto dto) {

    	AtividadeFilhoUsuarioBuilder builder = AtividadeFilhoUsuario.builder()
    			.id(dto.getId())
                .atividadeFilho(dto.getAtividadeFilho()!=null? atividadeFilhoMapper.toEntity(dto.getAtividadeFilho()) :null)
                .usuario(dto.getUsuario()!=null? usuarioMapper.toEntity(dto.getUsuario()) :null)
                .inicio(dto.getInicio())
                .fim(dto.getFim())
                .status(dto.getStatus().getCodigo())
                .nota(dto.getNota());
    	
         return builder.build();
    }

}

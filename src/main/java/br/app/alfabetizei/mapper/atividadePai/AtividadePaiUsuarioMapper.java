package br.app.alfabetizei.mapper.atividadePai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.app.alfabetizei.dto.atividadePai.AtividadePaiUsuarioDto.AtividadePaiUsuarioDtoBuilder;
import br.app.alfabetizei.enums.StatusAtividadePaiEnum;
import br.app.alfabetizei.dto.atividadePai.AtividadePaiUsuarioDto;
import br.app.alfabetizei.mapper.AbstractMapper;
import br.app.alfabetizei.mapper.UsuarioMapper;
import br.app.alfabetizei.model.atividadePai.AtividadePaiUsuario.AtividadePaiUsuarioBuilder;
import br.app.alfabetizei.model.atividadePai.AtividadePaiUsuario;

@ComponentScan
@Component
public class AtividadePaiUsuarioMapper extends AbstractMapper<AtividadePaiUsuarioDto, AtividadePaiUsuario> {
	
	@Autowired
	private AtividadePaiMapper atividadePaiMapper;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
    @Override
    public AtividadePaiUsuarioDto toDto(AtividadePaiUsuario entity) {
    	if(entity == null) return null;
    	
    	AtividadePaiUsuarioDtoBuilder builder = AtividadePaiUsuarioDto.builder()
                .id(entity.getId())
                .atividadePai(entity.getAtividadePai()!=null?atividadePaiMapper.toDto(entity.getAtividadePai()):null)
                .usuario(entity.getUsuario()!=null?usuarioMapper.toDto(entity.getUsuario()):null)
                .inicio(entity.getInicio())
                .fim(entity.getFim())
                .status(StatusAtividadePaiEnum.getEnum(entity.getStatus()));

        return builder.build();
    }

    @Override
    public AtividadePaiUsuario toEntity(AtividadePaiUsuarioDto dto) {
    	if(dto == null) return null;
    	
    	AtividadePaiUsuarioBuilder builder = AtividadePaiUsuario.builder()
    			.id(dto.getId())
                .atividadePai(dto.getAtividadePai()!=null?atividadePaiMapper.toEntity(dto.getAtividadePai()):null)
                .usuario(dto.getUsuario()!=null?usuarioMapper.toEntity(dto.getUsuario()):null)
                .inicio(dto.getInicio())
                .fim(dto.getFim())
                .status(dto.getStatus().getCodigo());
    	
         return builder.build();
    }

}

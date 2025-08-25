package br.app.alfabetizei.mapper;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.app.alfabetizei.dto.UsuarioDto;
import br.app.alfabetizei.dto.UsuarioDto.UsuarioDtoBuilder;
import br.app.alfabetizei.model.Usuario;
import br.app.alfabetizei.model.Usuario.UsuarioBuilder;

@ComponentScan
@Component
public class UsuarioMapper extends AbstractMapper<UsuarioDto, Usuario> {
	
    @Override
    public UsuarioDto toDto(Usuario entity) {
    	
    	UsuarioDtoBuilder builder = UsuarioDto.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .nomePai(entity.getNomePai())
                .nomeMae(entity.getNomeMae())
                .modeloCelular(entity.getModeloCelular())
                .uuid(entity.getUuid());

        return builder.build();
    }

    @Override
    public Usuario toEntity(UsuarioDto dto) {

    	UsuarioBuilder builder = Usuario.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .nomePai(dto.getNomePai())
                .nomeMae(dto.getNomeMae())
                .modeloCelular(dto.getModeloCelular())
                .uuid(dto.getUuid());
                
         return builder.build();
    }

}

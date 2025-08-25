package br.app.alfabetizei.mapper.atividadeFilho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoLetrasPontilhadasUsuarioDto;
import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoLetrasPontilhadasUsuarioDto.AtividadeFilhoLetrasPontilhadasUsuarioDtoBuilder;
import br.app.alfabetizei.mapper.AbstractMapper;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoLetrasPontilhadasUsuario;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoLetrasPontilhadasUsuario.AtividadeFilhoLetrasPontilhadasUsuarioBuilder;

@ComponentScan
@Component
public class AtividadeFilhoLetrasPontilhadasUsuarioMapper extends AbstractMapper<AtividadeFilhoLetrasPontilhadasUsuarioDto, AtividadeFilhoLetrasPontilhadasUsuario> {
	
	@Autowired
	private AtividadeFilhoUsuarioMapper atividadeFilhoUsuarioMapper;
	
    @Override
    public AtividadeFilhoLetrasPontilhadasUsuarioDto toDto(AtividadeFilhoLetrasPontilhadasUsuario entity) {
    	
    	AtividadeFilhoLetrasPontilhadasUsuarioDtoBuilder builder = AtividadeFilhoLetrasPontilhadasUsuarioDto.builder()
                .id(entity.getId())
                .atividadeFilhoUsuario(entity.getAtividadeFilhoUsuario()!=null? atividadeFilhoUsuarioMapper.toDto(entity.getAtividadeFilhoUsuario()) :null)
                .sequencial(entity.getSequencial())
                .letras(entity.getLetras())
                .desenhoBase64(entity.getDesenhoBase64());
        return builder.build();
    }

    @Override
    public AtividadeFilhoLetrasPontilhadasUsuario toEntity(AtividadeFilhoLetrasPontilhadasUsuarioDto dto) {

    	AtividadeFilhoLetrasPontilhadasUsuarioBuilder builder = AtividadeFilhoLetrasPontilhadasUsuario.builder()
    			.id(dto.getId())
                .atividadeFilhoUsuario(dto.getAtividadeFilhoUsuario()!=null? atividadeFilhoUsuarioMapper.toEntity(dto.getAtividadeFilhoUsuario()) :null)
                .sequencial(dto.getSequencial())
                .letras(dto.getLetras())
                .desenhoBase64(dto.getDesenhoBase64());
        
    	
         return builder.build();
    }

}

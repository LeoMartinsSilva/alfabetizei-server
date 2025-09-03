package br.app.alfabetizei.mapper.atividadeFilho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoLetrasPontilhadasDto;
import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoLetrasPontilhadasDto.AtividadeFilhoLetrasPontilhadasDtoBuilder;
import br.app.alfabetizei.enums.VariavelLetrasPontilhadasEnum;
import br.app.alfabetizei.mapper.AbstractMapper;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoLetrasPontilhadas;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoLetrasPontilhadas.AtividadeFilhoLetrasPontilhadasBuilder;

@ComponentScan
@Component
public class AtividadeFilhoLetrasPontilhadasMapper extends AbstractMapper<AtividadeFilhoLetrasPontilhadasDto, AtividadeFilhoLetrasPontilhadas> {
	
	@Autowired
	private AtividadeFilhoMapper atividadeFilhoMapper;
	
    @Override
    public AtividadeFilhoLetrasPontilhadasDto toDto(AtividadeFilhoLetrasPontilhadas entity) {
    	
    	AtividadeFilhoLetrasPontilhadasDtoBuilder builder = AtividadeFilhoLetrasPontilhadasDto.builder()
                .id(entity.getId())
                .atividadeFilho(entity.getAtividadeFilho()!=null? atividadeFilhoMapper.toDto(entity.getAtividadeFilho()) :null)
                .sequencial(entity.getSequencial())
                .letras(entity.getLetras())
                .usaNomes(entity.isUsaNomes())
                .variavel(VariavelLetrasPontilhadasEnum.getEnum(entity.getVariavel()));

        return builder.build();
    }

    @Override
    public AtividadeFilhoLetrasPontilhadas toEntity(AtividadeFilhoLetrasPontilhadasDto dto) {

    	AtividadeFilhoLetrasPontilhadasBuilder builder = AtividadeFilhoLetrasPontilhadas.builder()
    			.id(dto.getId())
                .atividadeFilho(dto.getAtividadeFilho()!=null? atividadeFilhoMapper.toEntity(dto.getAtividadeFilho()) :null)
                .sequencial(dto.getSequencial())
                .letras(dto.getLetras())
                .usaNomes(dto.isUsaNomes())
                .variavel(dto.getVariavel()!=null ? dto.getVariavel().getCodigo(): null);
    	
         return builder.build();
    }

}

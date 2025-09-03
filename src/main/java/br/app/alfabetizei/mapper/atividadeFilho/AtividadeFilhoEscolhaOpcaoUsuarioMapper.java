package br.app.alfabetizei.mapper.atividadeFilho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoEscolhaOpcaoUsuarioDto;
import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoEscolhaOpcaoUsuarioDto.AtividadeFilhoEscolhaOpcaoUsuarioDtoBuilder;
import br.app.alfabetizei.mapper.AbstractMapper;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoEscolhaOpcaoUsuario;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoEscolhaOpcaoUsuario.AtividadeFilhoEscolhaOpcaoUsuarioBuilder;

@ComponentScan
@Component
public class AtividadeFilhoEscolhaOpcaoUsuarioMapper extends AbstractMapper<AtividadeFilhoEscolhaOpcaoUsuarioDto, AtividadeFilhoEscolhaOpcaoUsuario> {
	
	@Autowired
	private AtividadeFilhoEscolhaUsuarioMapper atividadeFilhoEscolhaUsuarioMapper;
	
    @Override
    public AtividadeFilhoEscolhaOpcaoUsuarioDto toDto(AtividadeFilhoEscolhaOpcaoUsuario entity) {
    	
    	AtividadeFilhoEscolhaOpcaoUsuarioDtoBuilder builder = AtividadeFilhoEscolhaOpcaoUsuarioDto.builder()
                .id(entity.getId())
                .atividadeFilhoEscolhaUsuario(entity.getAtividadeFilhoEscolhaUsuario()!=null? atividadeFilhoEscolhaUsuarioMapper.toDto(entity.getAtividadeFilhoEscolhaUsuario()) :null)
                .sequencial(entity.getSequencial())
                .descricao(entity.getDescricao())
                .opcaoCorreta(entity.getOpcaoCorreta())
                .opcaoEscolhida(entity.getOpcaoEscolhida())
                .temImagem(entity.getTemImagem());

        return builder.build();
    }

    @Override
    public AtividadeFilhoEscolhaOpcaoUsuario toEntity(AtividadeFilhoEscolhaOpcaoUsuarioDto dto) {

    	AtividadeFilhoEscolhaOpcaoUsuarioBuilder builder = AtividadeFilhoEscolhaOpcaoUsuario.builder()
    			.id(dto.getId())
                .atividadeFilhoEscolhaUsuario(dto.getAtividadeFilhoEscolhaUsuario()!=null? atividadeFilhoEscolhaUsuarioMapper.toEntity(dto.getAtividadeFilhoEscolhaUsuario()) :null)
                .sequencial(dto.getSequencial())
                .descricao(dto.getDescricao())
                .opcaoCorreta(dto.getOpcaoCorreta())
                .opcaoEscolhida(dto.getOpcaoEscolhida())
                .temImagem(dto.getTemImagem());
    	
         return builder.build();
    }

}

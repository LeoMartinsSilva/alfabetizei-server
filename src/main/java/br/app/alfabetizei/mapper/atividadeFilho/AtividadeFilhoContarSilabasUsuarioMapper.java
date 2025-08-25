package br.app.alfabetizei.mapper.atividadeFilho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoContarSilabasUsuarioDto;
import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoContarSilabasUsuarioDto.AtividadeFilhoContarSilabasUsuarioDtoBuilder;
import br.app.alfabetizei.enums.StatusAtividadeFilhoItemEnum;
import br.app.alfabetizei.mapper.AbstractMapper;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoContarSilabasUsuario;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoContarSilabasUsuario.AtividadeFilhoContarSilabasUsuarioBuilder;

@ComponentScan
@Component
public class AtividadeFilhoContarSilabasUsuarioMapper extends AbstractMapper<AtividadeFilhoContarSilabasUsuarioDto, AtividadeFilhoContarSilabasUsuario> {
	
	@Autowired
	private AtividadeFilhoUsuarioMapper atividadeFilhoUsuarioMapper;
	
    @Override
    public AtividadeFilhoContarSilabasUsuarioDto toDto(AtividadeFilhoContarSilabasUsuario entity) {
    	
    	AtividadeFilhoContarSilabasUsuarioDtoBuilder builder = AtividadeFilhoContarSilabasUsuarioDto.builder()
                .id(entity.getId())
                .atividadeFilhoUsuario(entity.getAtividadeFilhoUsuario()!=null? atividadeFilhoUsuarioMapper.toDto(entity.getAtividadeFilhoUsuario()) :null)
                .sequencial(entity.getSequencial())
                .palavra(entity.getPalavra())
                .numeroSilabas(entity.getNumeroSilabas())
                .numeroSilabasSelecionada(entity.getNumeroSilabasSelecionada())
                .acertou(entity.getAcertou())
                .status(StatusAtividadeFilhoItemEnum.getEnum(entity.getStatus()));

        return builder.build();
    }

    @Override
    public AtividadeFilhoContarSilabasUsuario toEntity(AtividadeFilhoContarSilabasUsuarioDto dto) {

    	AtividadeFilhoContarSilabasUsuarioBuilder builder = AtividadeFilhoContarSilabasUsuario.builder()
    			.id(dto.getId())
                .atividadeFilhoUsuario(dto.getAtividadeFilhoUsuario()!=null? atividadeFilhoUsuarioMapper.toEntity(dto.getAtividadeFilhoUsuario()) :null)
                .sequencial(dto.getSequencial())
                .palavra(dto.getPalavra())
                .numeroSilabas(dto.getNumeroSilabas())
                .numeroSilabasSelecionada(dto.getNumeroSilabasSelecionada())
                .acertou(dto.getAcertou())
                .status(dto.getStatus().getCodigo());
    	
         return builder.build();
    }

}

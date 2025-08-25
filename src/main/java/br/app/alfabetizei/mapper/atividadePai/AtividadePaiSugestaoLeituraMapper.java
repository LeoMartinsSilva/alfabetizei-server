package br.app.alfabetizei.mapper.atividadePai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.app.alfabetizei.dto.atividadePai.AtividadePaiSugestaoLeituraDto.AtividadePaiSugestaoLeituraDtoBuilder;
import br.app.alfabetizei.dto.atividadePai.AtividadePaiSugestaoLeituraDto;
import br.app.alfabetizei.mapper.AbstractMapper;
import br.app.alfabetizei.model.atividadePai.AtividadePaiSugestaoLeitura.AtividadePaiSugestaoLeituraBuilder;
import br.app.alfabetizei.model.atividadePai.AtividadePaiSugestaoLeitura;

@ComponentScan
@Component
public class AtividadePaiSugestaoLeituraMapper extends AbstractMapper<AtividadePaiSugestaoLeituraDto, AtividadePaiSugestaoLeitura> {
	
	@Autowired
	private AtividadePaiMapper atividadePaiMapper;
	
    @Override
    public AtividadePaiSugestaoLeituraDto toDto(AtividadePaiSugestaoLeitura entity) {
    	
    	AtividadePaiSugestaoLeituraDtoBuilder builder = AtividadePaiSugestaoLeituraDto.builder()
                .id(entity.getId())
                .atividadePai(entity.getAtividadePai()!=null?atividadePaiMapper.toDto(entity.getAtividadePai()):null)
                .sequencial(entity.getSequencial())
                .titulo(entity.getTitulo())
                .descricao(entity.getDescricao())
                .imagemBase64(entity.getImagemBase64());

        return builder.build();
    }

    @Override
    public AtividadePaiSugestaoLeitura toEntity(AtividadePaiSugestaoLeituraDto dto) {

    	AtividadePaiSugestaoLeituraBuilder builder = AtividadePaiSugestaoLeitura.builder()
    			.id(dto.getId())
                .atividadePai(dto.getAtividadePai()!=null?atividadePaiMapper.toEntity(dto.getAtividadePai()):null)
                .sequencial(dto.getSequencial())
                .titulo(dto.getTitulo())
                .descricao(dto.getDescricao())
                .imagemBase64(dto.getImagemBase64());
    	
         return builder.build();
    }

}

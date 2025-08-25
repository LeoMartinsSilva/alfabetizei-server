package br.app.alfabetizei.dto.atividadePai;

import java.util.List;

import br.app.alfabetizei.enums.TipoAtividadePaiEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtividadePaiDto {
	private Long id;
	private String titulo;
	private String subtitulo;
	private TipoAtividadePaiEnum tipo;
	private List<AtividadePaiSugestaoLeituraDto> itensLeitura;
	private List<AtividadePaiSugestaoVideoDto> itensVideo;
	private List<AtividadePaiTextoDto> itensTexto;
}

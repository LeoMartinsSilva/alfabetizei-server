package br.app.alfabetizei.dto.atividadeFilho;

import java.util.List;

import br.app.alfabetizei.enums.TipoAtividadeFilhoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtividadeFilhoDto {
	private Long id;
	private String titulo;
	private String subtitulo;
	private TipoAtividadeFilhoEnum tipo;
	private Integer tempoEstimadoMinutos;
	private Boolean contaEstrelas;
	private List<AtividadeFilhoContarSilabasDto> itensContarSilabas;
	private List<AtividadeFilhoEscolhaDto> itensEscolha;
	private List<AtividadeFilhoLetrasPontilhadasDto> itensLetrasPontilhadas;
}

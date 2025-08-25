package br.app.alfabetizei.dto.atividadePai;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtividadePaiSugestaoVideoDto {
	private Long id;
	private AtividadePaiDto atividadePai;
	private Integer sequencial;
	private String titulo;
	private String descricao;
}

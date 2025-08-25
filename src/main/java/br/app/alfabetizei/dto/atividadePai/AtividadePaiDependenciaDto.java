package br.app.alfabetizei.dto.atividadePai;

import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtividadePaiDependenciaDto {
	private Long id;
	private AtividadePaiDto atividadePai;
	private AtividadeFilhoDto atividadeFilhoPredecessora;
	private AtividadePaiDto atividadePaiPredecessora;

}

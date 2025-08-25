package br.app.alfabetizei.dto.atividadeFilho;

import br.app.alfabetizei.dto.atividadePai.AtividadePaiDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtividadeFilhoDependenciaDto {
	private Long id;
	private AtividadeFilhoDto atividadeFilho;
	private AtividadeFilhoDto atividadeFilhoPredecessora;
	private AtividadePaiDto atividadePaiPredecessora;
}

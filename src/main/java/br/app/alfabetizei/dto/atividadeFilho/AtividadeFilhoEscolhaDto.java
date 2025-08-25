package br.app.alfabetizei.dto.atividadeFilho;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtividadeFilhoEscolhaDto {
	private Long id;
	private AtividadeFilhoDto atividadeFilho;
	private Integer sequencial;
	private List<AtividadeFilhoEscolhaOpcaoDto> opcoes;
}

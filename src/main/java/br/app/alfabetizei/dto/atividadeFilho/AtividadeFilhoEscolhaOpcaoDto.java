package br.app.alfabetizei.dto.atividadeFilho;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtividadeFilhoEscolhaOpcaoDto {
	private Long id;
	private AtividadeFilhoEscolhaDto atividadeFilhoEscolha;
	private Integer sequencial;
	private String descricao;
	private Boolean opcaoCorreta;
	private Boolean temImagem;
}

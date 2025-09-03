package br.app.alfabetizei.dto.atividadeFilho;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtividadeFilhoEscolhaOpcaoUsuarioDto {
	private Long id;
	private AtividadeFilhoEscolhaUsuarioDto atividadeFilhoEscolhaUsuario;
	private Integer sequencial;
	private String descricao;
	private Boolean opcaoCorreta;
	private Boolean opcaoEscolhida;
	private Boolean temImagem;
}

package br.app.alfabetizei.dto.atividadeFilho;

import java.util.List;

import br.app.alfabetizei.enums.StatusAtividadeFilhoItemEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtividadeFilhoEscolhaUsuarioDto {
	private Long id;
	private AtividadeFilhoUsuarioDto atividadeFilhoUsuario;
	private Integer sequencial;
	private List<AtividadeFilhoEscolhaOpcaoUsuarioDto> opcoes;
	private StatusAtividadeFilhoItemEnum status;
	private Boolean acertou;
}

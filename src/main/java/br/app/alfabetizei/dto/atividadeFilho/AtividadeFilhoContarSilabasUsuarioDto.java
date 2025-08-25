package br.app.alfabetizei.dto.atividadeFilho;

import br.app.alfabetizei.enums.StatusAtividadeFilhoItemEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtividadeFilhoContarSilabasUsuarioDto {
	private Long id;
	private AtividadeFilhoUsuarioDto atividadeFilhoUsuario;
	private Integer sequencial;
	private String palavra;
	private Integer numeroSilabas;
	private Integer numeroSilabasSelecionada;
	private Boolean acertou;
	private StatusAtividadeFilhoItemEnum status;
}

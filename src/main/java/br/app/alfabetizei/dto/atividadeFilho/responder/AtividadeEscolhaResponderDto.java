package br.app.alfabetizei.dto.atividadeFilho.responder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtividadeEscolhaResponderDto {
	private Long idAtividadeFilhoEscolhaUsuario;
	private Long idOpcaoEscolhida;
}

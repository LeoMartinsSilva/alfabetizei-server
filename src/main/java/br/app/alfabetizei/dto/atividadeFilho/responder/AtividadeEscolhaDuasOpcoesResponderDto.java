package br.app.alfabetizei.dto.atividadeFilho.responder;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtividadeEscolhaDuasOpcoesResponderDto {
	private Long idAtividadeFilhoEscolhaUsuario;
	private List<Long> idOpcoesEscolhidas;
}

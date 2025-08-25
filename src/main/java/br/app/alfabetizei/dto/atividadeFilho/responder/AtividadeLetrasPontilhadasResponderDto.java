package br.app.alfabetizei.dto.atividadeFilho.responder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtividadeLetrasPontilhadasResponderDto {
	private Long idAtividadeFilhoLetrasPontilhadasUsuario;
	private String desenhoBase64;
}

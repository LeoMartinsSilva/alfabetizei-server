package br.app.alfabetizei.dto.atividadePai;

import java.time.LocalDateTime;

import br.app.alfabetizei.dto.UsuarioDto;
import br.app.alfabetizei.enums.StatusAtividadePaiEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtividadePaiUsuarioDto {
	private Long id;
	private AtividadePaiDto atividadePai;
	private UsuarioDto usuario;
	private LocalDateTime inicio;
	private LocalDateTime fim;
	private StatusAtividadePaiEnum status;

}

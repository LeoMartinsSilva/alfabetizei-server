package br.app.alfabetizei.dto.atividadeFilho;

import java.time.LocalDateTime;
import java.util.List;

import br.app.alfabetizei.dto.UsuarioDto;
import br.app.alfabetizei.enums.StatusAtividadeFilhoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtividadeFilhoUsuarioDto {
	private Long id;
	private AtividadeFilhoDto atividadeFilho;
	private UsuarioDto usuario;
	private LocalDateTime inicio;
	private LocalDateTime fim;
	private StatusAtividadeFilhoEnum status;
	private Integer nota;
	private List<AtividadeFilhoContarSilabasUsuarioDto> itensContarSilabas;
	private List<AtividadeFilhoEscolhaUsuarioDto> itensEscolha;
	private List<AtividadeFilhoLetrasPontilhadasUsuarioDto> itensLetrasPontilhadas;

}

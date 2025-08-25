package br.app.alfabetizei.dto.atividadeFilho;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtividadeFilhoLetrasPontilhadasUsuarioDto {
	private Long id;
	private AtividadeFilhoUsuarioDto atividadeFilhoUsuario;
	private Integer sequencial;
	private String letras;
	private String desenhoBase64;
}

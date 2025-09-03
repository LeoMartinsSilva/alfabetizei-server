package br.app.alfabetizei.dto.atividadeFilho;

import br.app.alfabetizei.enums.VariavelLetrasPontilhadasEnum;
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
	private boolean usaNomes;
	private VariavelLetrasPontilhadasEnum variavel;
}

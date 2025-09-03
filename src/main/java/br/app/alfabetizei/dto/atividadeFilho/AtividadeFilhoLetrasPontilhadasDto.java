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
public class AtividadeFilhoLetrasPontilhadasDto {
	private Long id;
	private AtividadeFilhoDto atividadeFilho;
	private Integer sequencial;
	private String letras;
	private boolean usaNomes;
	private VariavelLetrasPontilhadasEnum variavel;
}

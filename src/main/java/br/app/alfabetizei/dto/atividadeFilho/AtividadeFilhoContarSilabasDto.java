package br.app.alfabetizei.dto.atividadeFilho;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtividadeFilhoContarSilabasDto {
	private Long id;
	private AtividadeFilhoDto atividadeFilho;
	private Integer sequencial;
	private String palavra;
	private Integer numeroSilabas;
}

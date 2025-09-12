package br.app.alfabetizei.dto.atividadeFilho;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtividadeFilhoResumoDto {
	private Long numeroDeAtividades;
	private Long atividadesRealizadas;

	private Long numeroDeEstrelas;
	private Long estrelasColetadas;
}

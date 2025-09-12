package br.app.alfabetizei.dto.atividadePai;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AtividadePaiResumoDto {
	private Long numeroDeAtividades;
	private Long atividadesRealizadas;
}

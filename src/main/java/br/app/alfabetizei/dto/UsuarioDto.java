package br.app.alfabetizei.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDto {
	private Long id;
	private String nome;
	private String nomeMae;
	private String nomePai;
	private String modeloCelular;
	private String uuid;
}

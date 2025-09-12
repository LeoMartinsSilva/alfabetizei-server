package br.app.alfabetizei.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum TipoAtividadeFilhoEnum {
	
	LETRAS_PONTILHADAS("LP", "Letras pontilhadas"), 
	NOMES_PONTILHADOS("NP", "Nomes pontilhados"),
	MULTIPLA_ESCOLHA("ME", "Multipla Escolha"),
	MULTIPLA_ESCOLHA_DUAS_OPCOES("MD", "Multipla Escolha Duas Opções"),
	SILABAS("S", "Silabas");

	private final String codigo;
	private final String descricao;

	private TipoAtividadeFilhoEnum(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoAtividadeFilhoEnum getEnum(String valor) {
		if(valor == null) return null;
		List<TipoAtividadeFilhoEnum> enums = new ArrayList<TipoAtividadeFilhoEnum>(
				EnumSet.allOf(TipoAtividadeFilhoEnum.class));

		for (TipoAtividadeFilhoEnum enume : enums) {
			if (enume.getCodigo().equals(valor)) {
				return enume;
			}
		}

		return null;
	}
}

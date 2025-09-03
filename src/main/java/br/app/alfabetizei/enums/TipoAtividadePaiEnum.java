package br.app.alfabetizei.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum TipoAtividadePaiEnum {
	
	ATIVIDADE_PRATICA("AP", "Atividade prática"), 
	ATIVIDADE_TEORICA("AT", "Atividade teórica"),
	LEITURA_COMPARTILADA("LC", "Leitura compartilhada");

	private final String codigo;
	private final String descricao;

	private TipoAtividadePaiEnum(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoAtividadePaiEnum getEnum(String valor) {
		if(valor == null) return null;
		List<TipoAtividadePaiEnum> enums = new ArrayList<TipoAtividadePaiEnum>(
				EnumSet.allOf(TipoAtividadePaiEnum.class));

		for (TipoAtividadePaiEnum enume : enums) {
			if (enume.getCodigo().equals(valor)) {
				return enume;
			}
		}

		return null;
	}
}

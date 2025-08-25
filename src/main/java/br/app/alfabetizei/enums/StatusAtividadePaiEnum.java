package br.app.alfabetizei.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum StatusAtividadePaiEnum {
	
	BLOQUEADA("B", "Bloqueada"), 
	LIBERADA("L", "Liberada"),
	FINALIZADA("F", "Finalizada");

	private final String codigo;
	private final String descricao;

	private StatusAtividadePaiEnum(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static StatusAtividadePaiEnum getEnum(String valor) {
		if(valor == null) return null;
		List<StatusAtividadePaiEnum> enums = new ArrayList<StatusAtividadePaiEnum>(
				EnumSet.allOf(StatusAtividadePaiEnum.class));

		for (StatusAtividadePaiEnum enume : enums) {
			if (enume.getCodigo().equals(valor)) {
				return enume;
			}
		}

		return null;
	}
}

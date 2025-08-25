package br.app.alfabetizei.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum StatusAtividadeFilhoEnum {
	
	BLOQUEADA("B", "Bloqueada"), 
	LIBERADA("L", "Liberada"),
	EM_ANDAMENTO("A", "Em andamento"),
	FINALIZADA("F", "Finalizada");

	private final String codigo;
	private final String descricao;

	private StatusAtividadeFilhoEnum(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static StatusAtividadeFilhoEnum getEnum(String valor) {
		if(valor == null) return null;
		List<StatusAtividadeFilhoEnum> enums = new ArrayList<StatusAtividadeFilhoEnum>(
				EnumSet.allOf(StatusAtividadeFilhoEnum.class));

		for (StatusAtividadeFilhoEnum enume : enums) {
			if (enume.getCodigo().equals(valor)) {
				return enume;
			}
		}

		return null;
	}
}

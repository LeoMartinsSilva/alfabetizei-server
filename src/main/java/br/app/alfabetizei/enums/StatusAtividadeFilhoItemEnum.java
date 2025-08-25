package br.app.alfabetizei.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum StatusAtividadeFilhoItemEnum {
	
	PENDENTE("P", "Pendente"),
	FINALIZADA("F", "Finalizada");

	private final String codigo;
	private final String descricao;

	private StatusAtividadeFilhoItemEnum(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static StatusAtividadeFilhoItemEnum getEnum(String valor) {
		if(valor == null) return null;
		List<StatusAtividadeFilhoItemEnum> enums = new ArrayList<StatusAtividadeFilhoItemEnum>(
				EnumSet.allOf(StatusAtividadeFilhoItemEnum.class));

		for (StatusAtividadeFilhoItemEnum enume : enums) {
			if (enume.getCodigo().equals(valor)) {
				return enume;
			}
		}

		return null;
	}
}

package br.app.alfabetizei.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum VariavelLetrasPontilhadasEnum {
	NOME("N", "Nome"), 
	NOME_PAI("NP", "Nome pai"),
	NOME_MAE("NM", "Nome mão");

	private final String codigo;
	private final String descricao;

	private VariavelLetrasPontilhadasEnum(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static VariavelLetrasPontilhadasEnum getEnum(String valor) {
		if(valor == null) return null;
		List<VariavelLetrasPontilhadasEnum> enums = new ArrayList<VariavelLetrasPontilhadasEnum>(
				EnumSet.allOf(VariavelLetrasPontilhadasEnum.class));

		for (VariavelLetrasPontilhadasEnum enume : enums) {
			if (enume.getCodigo().equals(valor)) {
				return enume;
			}
		}

		return null;
	}
}

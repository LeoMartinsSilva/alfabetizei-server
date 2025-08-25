package br.app.alfabetizei.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1)
	@Column(name = "id_usuario")
	private Long id;

	@Column(name = "ds_nome")
	private String nome;

	@Column(name = "ds_nome_mae")
	private String nomeMae;

	@Column(name = "ds_nome_pai")
	private String nomePai;

	@Column(name = "ds_modelo_celular")
	private String modeloCelular;
	
	@Column(name = "ds_uuid")
	private String uuid;

}

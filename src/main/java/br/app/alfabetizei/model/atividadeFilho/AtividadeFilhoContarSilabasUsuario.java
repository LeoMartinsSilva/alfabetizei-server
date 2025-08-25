package br.app.alfabetizei.model.atividadeFilho;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "ATIVIDADE_FILHO_CONTAR_SILABAS_USUARIO")
public class AtividadeFilhoContarSilabasUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_atividade_filho_contar_silabas_usuario")
	@SequenceGenerator(name = "seq_atividade_filho_contar_silabas_usuario", sequenceName = "seq_atividade_filho_contar_silabas_usuario", allocationSize = 1)
	@Column(name = "id_atividade_filho_contar_silabas_usuario")
	private Long id;
	
	@JoinColumn(name="id_atividade_filho_usuario", referencedColumnName = "id_atividade_filho_usuario")
	@ManyToOne
	private AtividadeFilhoUsuario atividadeFilhoUsuario;

	@Column(name = "sq_interno_atividade")
	private Integer sequencial;

	@Column(name = "ds_palavra")
	private String palavra;
	
	@Column(name = "nr_silabas")
	private Integer numeroSilabas;

	@Column(name = "nr_silabas_selecionada")
	private Integer numeroSilabasSelecionada;
	
	@Column(name = "fl_acertou")
	private Boolean acertou;
	
	@Column(name = "fl_status")
	private String status;
}

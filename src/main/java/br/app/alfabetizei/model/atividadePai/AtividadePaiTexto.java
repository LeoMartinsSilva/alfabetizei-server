package br.app.alfabetizei.model.atividadePai;

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
@Table(name = "ATIVIDADE_PAI_TEXTO")
public class AtividadePaiTexto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_atividade_pai_texto")
	@SequenceGenerator(name = "seq_atividade_pai_texto", sequenceName = "seq_atividade_pai_texto", allocationSize = 1)
	@Column(name = "id_atividade_pai_texto")
	private Long id;
	
	@JoinColumn(name="id_atividade_pai", referencedColumnName = "id_atividade_pai")
	@ManyToOne
	private AtividadePai atividadePai;

	@Column(name = "sq_interno_atividade")
	private Integer sequencial;

	@Column(name = "ds_titulo")
	private String titulo;

	@Column(name = "ds_texto")
	private String texto;

	@Column(name = "fl_tem_imagem")
	private Boolean temImagem;
	
}

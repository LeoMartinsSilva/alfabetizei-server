package br.app.alfabetizei.model.atividadePai;

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
@Table(name = "ATIVIDADE_PAI")
public class AtividadePai {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_atividade_pai")
	@SequenceGenerator(name = "seq_atividade_pai", sequenceName = "seq_atividade_pai", allocationSize = 1)
	@Column(name = "id_atividade_pai")
	private Long id;

	@Column(name = "ds_titulo")
	private String titulo;

	@Column(name = "ds_subtitulo")
	private String subtitulo;

	@Column(name = "fl_tipo")
	private String tipo;
	
	@Column(name="vl_tempo_estimado_minutos")
	private Integer tempoEstimadoMinutos;
	
}

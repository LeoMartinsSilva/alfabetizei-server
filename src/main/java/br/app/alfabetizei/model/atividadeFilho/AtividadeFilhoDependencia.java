package br.app.alfabetizei.model.atividadeFilho;

import br.app.alfabetizei.model.atividadePai.AtividadePai;
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
@Table(name = "ATIVIDADE_FILHO_DEPENDENCIA")
public class AtividadeFilhoDependencia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_atividade_filho_dependencia")
	@SequenceGenerator(name = "seq_atividade_filho_dependencia", sequenceName = "seq_atividade_filho_dependencia", allocationSize = 1)
	@Column(name = "id_atividade_filho_dependencia")
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_atividade_filho", referencedColumnName = "id_atividade_filho")
	private AtividadeFilho atividadeFilho;

	@ManyToOne
	@JoinColumn(name="id_atividade_filho_predecessora", referencedColumnName = "id_atividade_filho")
	private AtividadeFilho atividadeFilhoPredecessora;

	@ManyToOne
	@JoinColumn(name="id_atividade_pai_predecessora", referencedColumnName = "id_atividade_pai")
	private AtividadePai atividadePaiPredecessora;

}

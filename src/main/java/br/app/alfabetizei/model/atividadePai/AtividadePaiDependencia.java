package br.app.alfabetizei.model.atividadePai;

import br.app.alfabetizei.model.atividadeFilho.AtividadeFilho;
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
@Table(name = "ATIVIDADE_PAI_DEPENDENCIA")
public class AtividadePaiDependencia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_atividade_pai_dependencia")
	@SequenceGenerator(name = "seq_atividade_pai_dependencia", sequenceName = "seq_atividade_pai_dependencia", allocationSize = 1)
	@Column(name = "id_atividade_pai_dependencia")
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_atividade_pai", referencedColumnName = "id_atividade_pai")
	private AtividadePai atividadePai;

	@ManyToOne
	@JoinColumn(name="id_atividade_filho_predecessora", referencedColumnName = "id_atividade_filho")
	private AtividadeFilho atividadeFilhoPredecessora;

	@ManyToOne
	@JoinColumn(name="id_atividade_pai_predecessora", referencedColumnName = "id_atividade_pai")
	private AtividadePai atividadePaiPredecessora;

}

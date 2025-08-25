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
@Table(name = "ATIVIDADE_FILHO_ESCOLHA")
public class AtividadeFilhoEscolha {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_atividade_filho_escolha")
	@SequenceGenerator(name = "seq_atividade_filho_escolha", sequenceName = "seq_atividade_filho_escolha", allocationSize = 1)
	@Column(name = "id_atividade_filho_escolha")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_atividade_filho", referencedColumnName = "id_atividade_filho")
	private AtividadeFilho atividadeFilho;

	@Column(name = "sq_interno_atividade")
	private Integer sequencial;

}

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
@Table(name = "ATIVIDADE_FILHO_LETRAS_PONTILHADAS")
public class AtividadeFilhoLetrasPontilhadas {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_atividade_filho_letras_pontilhadas")
	@SequenceGenerator(name = "seq_atividade_filho_letras_pontilhadas", sequenceName = "seq_atividade_filho_letras_pontilhadas", allocationSize = 1)
	@Column(name = "id_atividade_filho_letras_pontilhadas")
	private Long id;
	
	@JoinColumn(name="id_atividade_filho", referencedColumnName = "id_atividade_filho")
	@ManyToOne
	private AtividadeFilho atividadeFilho;

	@Column(name = "sq_interno_atividade")
	private Integer sequencial;

	@Column(name = "ds_letras")
	private String letras;
	
	@Column(name = "fl_usa_nomes")
	private boolean usaNomes;
	
	@Column(name = "fl_variavel")
	private String variavel;

}

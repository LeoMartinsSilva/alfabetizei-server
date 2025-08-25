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
@Table(name = "ATIVIDADE_FILHO_ESCOLHA_USUARIO")
public class AtividadeFilhoEscolhaUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_atividade_filho_escolha_usuario")
	@SequenceGenerator(name = "seq_atividade_filho_escolha_usuario", sequenceName = "seq_atividade_filho_escolha_usuario", allocationSize = 1)
	@Column(name = "id_atividade_filho_escolha_usuario")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_atividade_filho_usuario", referencedColumnName = "id_atividade_filho_usuario")
	private AtividadeFilhoUsuario atividadeFilhoUsuario;

	@Column(name = "sq_interno_atividade")
	private Integer sequencial;

	@Column(name = "fl_status")
	private String status;
	
	@Column(name = "fl_acertou")
	private Boolean acertou;
}

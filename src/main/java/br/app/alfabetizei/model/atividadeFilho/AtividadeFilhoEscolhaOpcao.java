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
@Table(name = "ATIVIDADE_FILHO_ESCOLHA_OPCAO")
public class AtividadeFilhoEscolhaOpcao {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_atividade_filho_escolha_opcao")
	@SequenceGenerator(name = "seq_atividade_filho_escolha_opcao", sequenceName = "seq_atividade_filho_escolha_opcao", allocationSize = 1)
	@Column(name = "id_atividade_filho_escolha_opcao")
	private Long id;
	
	@JoinColumn(name="id_atividade_filho_escolha", referencedColumnName = "id_atividade_filho_escolha")
	@ManyToOne
	private AtividadeFilhoEscolha atividadeFilhoEscolha;

	@Column(name = "sq_opcao")
	private Integer sequencial;

	@Column(name = "ds_opcao")
	private String descricao;

	@Column(name = "fl_opcao_correta")
	private Boolean opcaoCorreta;
	
	@Column(name = "fl_tem_imagem")
	private Boolean temImagem;
	
}

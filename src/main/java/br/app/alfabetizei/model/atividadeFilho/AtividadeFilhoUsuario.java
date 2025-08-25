package br.app.alfabetizei.model.atividadeFilho;

import java.time.LocalDateTime;

import br.app.alfabetizei.model.Usuario;
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
@Table(name = "ATIVIDADE_FILHO_USUARIO")
public class AtividadeFilhoUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_atividade_filho_usuario")
	@SequenceGenerator(name = "seq_atividade_filho_usuario", sequenceName = "seq_atividade_filho_usuario", allocationSize = 1)
	@Column(name = "id_atividade_filho_usuario")
	private Long id;
	
	@JoinColumn(name="id_atividade_filho", referencedColumnName = "id_atividade_filho")
	@ManyToOne
	private AtividadeFilho atividadeFilho;

	@JoinColumn(name="id_usuario", referencedColumnName = "id_usuario")
	@ManyToOne
	private Usuario usuario;
	
	@Column(name = "dh_inicio")
	private LocalDateTime inicio;

	@Column(name = "dh_fim")
	private LocalDateTime fim;
	
	@Column(name = "fl_status")
	private String status;

	@Column(name = "vl_nota")
	private Integer nota;
}

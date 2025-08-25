package br.app.alfabetizei.model.atividadePai;

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
@Table(name = "ATIVIDADE_PAI_USUARIO")
public class AtividadePaiUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_atividade_pai_usuario")
	@SequenceGenerator(name = "seq_atividade_pai_usuario", sequenceName = "seq_atividade_pai_usuario", allocationSize = 1)
	@Column(name = "id_atividade_pai_usuario")
	private Long id;
	
	@JoinColumn(name="id_atividade_pai", referencedColumnName = "id_atividade_pai")
	@ManyToOne
	private AtividadePai atividadePai;

	@JoinColumn(name="id_usuario", referencedColumnName = "id_usuario")
	@ManyToOne
	private Usuario usuario;
	
	@Column(name = "dh_inicio")
	private LocalDateTime inicio;

	@Column(name = "dh_fim")
	private LocalDateTime fim;
	
	@Column(name = "fl_status")
	private String status;

}

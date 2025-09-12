package br.app.alfabetizei.repository.atividadeFilho;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoUsuario;

public interface AtividadeFilhoUsuarioRepository extends JpaRepository<AtividadeFilhoUsuario, Long> {

	AtividadeFilhoUsuario getByAtividadeFilhoIdAndUsuarioId(Long idAtividadeFilho, Long idUsuario);

	@Query("select count(afu) from AtividadeFilhoUsuario afu where afu.usuario.id=:idUsuario and afu.status='F' ")
	Long countByUsuarioIdAndFinalizada(Long idUsuario);

	@Query("select SUM(afu.nota) from AtividadeFilhoUsuario afu where afu.usuario.id=:idUsuario and afu.atividadeFilho.contaEstrelas=true")
	Long getEstrelasColetadasByUsuarioId(Long idUsuario);

}

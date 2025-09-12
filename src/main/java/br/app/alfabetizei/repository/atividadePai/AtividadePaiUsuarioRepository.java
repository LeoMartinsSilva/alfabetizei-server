package br.app.alfabetizei.repository.atividadePai;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.app.alfabetizei.model.atividadePai.AtividadePaiUsuario;

public interface AtividadePaiUsuarioRepository extends JpaRepository<AtividadePaiUsuario, Long> {

	AtividadePaiUsuario getByAtividadePaiIdAndUsuarioId(Long id, Long idUsuario);

	@Query("select count(apu) from AtividadePaiUsuario apu where apu.usuario.id=:idUsuario and apu.status='F'")
	Long countByUsuarioIdAndFinalizada(Long idUsuario);

}

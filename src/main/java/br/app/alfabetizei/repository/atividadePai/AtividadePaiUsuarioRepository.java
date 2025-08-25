package br.app.alfabetizei.repository.atividadePai;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.alfabetizei.model.atividadePai.AtividadePaiUsuario;

public interface AtividadePaiUsuarioRepository extends JpaRepository<AtividadePaiUsuario, Long> {

	AtividadePaiUsuario getByAtividadePaiIdAndUsuarioId(Long id, Long idUsuario);

}

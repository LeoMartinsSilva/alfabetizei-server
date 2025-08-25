package br.app.alfabetizei.repository.atividadeFilho;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoUsuario;

public interface AtividadeFilhoUsuarioRepository extends JpaRepository<AtividadeFilhoUsuario, Long> {

	AtividadeFilhoUsuario getByAtividadeFilhoIdAndUsuarioId(Long idAtividadeFilho, Long idUsuario);

}

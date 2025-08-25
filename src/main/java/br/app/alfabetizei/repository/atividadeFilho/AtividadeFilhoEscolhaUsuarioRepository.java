package br.app.alfabetizei.repository.atividadeFilho;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoEscolhaUsuario;

public interface AtividadeFilhoEscolhaUsuarioRepository extends JpaRepository<AtividadeFilhoEscolhaUsuario, Long> {

	List<AtividadeFilhoEscolhaUsuario> findAllByAtividadeFilhoUsuarioIdOrderBySequencial(Long id);

}

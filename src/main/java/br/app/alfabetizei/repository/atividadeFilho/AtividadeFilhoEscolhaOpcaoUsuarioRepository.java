package br.app.alfabetizei.repository.atividadeFilho;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoEscolhaOpcaoUsuario;

public interface AtividadeFilhoEscolhaOpcaoUsuarioRepository extends JpaRepository<AtividadeFilhoEscolhaOpcaoUsuario, Long> {

	List<AtividadeFilhoEscolhaOpcaoUsuario> findAllByAtividadeFilhoEscolhaUsuarioIdOrderBySequencial(Long id);

}

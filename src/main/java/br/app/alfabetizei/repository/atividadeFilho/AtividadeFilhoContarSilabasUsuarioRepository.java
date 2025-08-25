package br.app.alfabetizei.repository.atividadeFilho;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoContarSilabasUsuario;

public interface AtividadeFilhoContarSilabasUsuarioRepository extends JpaRepository<AtividadeFilhoContarSilabasUsuario, Long> {

	List<AtividadeFilhoContarSilabasUsuario> findAllByAtividadeFilhoUsuarioIdOrderBySequencial(Long id);

}

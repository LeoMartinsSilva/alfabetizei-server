package br.app.alfabetizei.repository.atividadeFilho;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoLetrasPontilhadasUsuario;

public interface AtividadeFilhoLetrasPontilhadasUsuarioRepository extends JpaRepository<AtividadeFilhoLetrasPontilhadasUsuario, Long> {

	List<AtividadeFilhoLetrasPontilhadasUsuario> findAllByAtividadeFilhoUsuarioIdOrderBySequencial(Long id);

}

package br.app.alfabetizei.repository.atividadeFilho;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoEscolha;

public interface AtividadeFilhoEscolhaRepository extends JpaRepository<AtividadeFilhoEscolha, Long> {

	List<AtividadeFilhoEscolha> findAllByAtividadeFilhoId(Long id);

}

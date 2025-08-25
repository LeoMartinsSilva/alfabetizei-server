package br.app.alfabetizei.repository.atividadeFilho;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoDependencia;

public interface AtividadeFilhoDependenciaRepository extends JpaRepository<AtividadeFilhoDependencia, Long> {

	List<AtividadeFilhoDependencia> findAllByAtividadeFilhoId(Long idAtividade);

}

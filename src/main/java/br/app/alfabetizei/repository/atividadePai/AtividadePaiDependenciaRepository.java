package br.app.alfabetizei.repository.atividadePai;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.alfabetizei.model.atividadePai.AtividadePaiDependencia;

public interface AtividadePaiDependenciaRepository extends JpaRepository<AtividadePaiDependencia, Long> {

	List<AtividadePaiDependencia> findAllByAtividadePaiId(Long idAtividadePai);

}

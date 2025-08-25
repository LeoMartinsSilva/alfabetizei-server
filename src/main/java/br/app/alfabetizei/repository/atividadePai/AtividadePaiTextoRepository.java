package br.app.alfabetizei.repository.atividadePai;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.alfabetizei.model.atividadePai.AtividadePaiTexto;

public interface AtividadePaiTextoRepository extends JpaRepository<AtividadePaiTexto, Long> {

	List<AtividadePaiTexto> findAllByAtividadePaiId(Long idAtividade);

}

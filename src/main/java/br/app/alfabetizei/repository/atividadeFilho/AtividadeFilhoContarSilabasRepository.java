package br.app.alfabetizei.repository.atividadeFilho;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoContarSilabas;

public interface AtividadeFilhoContarSilabasRepository extends JpaRepository<AtividadeFilhoContarSilabas, Long> {

	List<AtividadeFilhoContarSilabas> findAllByAtividadeFilhoId(Long id);

}

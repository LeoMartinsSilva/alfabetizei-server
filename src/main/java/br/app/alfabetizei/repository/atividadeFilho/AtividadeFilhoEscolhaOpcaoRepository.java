package br.app.alfabetizei.repository.atividadeFilho;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoEscolhaOpcao;

public interface AtividadeFilhoEscolhaOpcaoRepository extends JpaRepository<AtividadeFilhoEscolhaOpcao, Long> {

	List<AtividadeFilhoEscolhaOpcao> findAllByAtividadeFilhoEscolhaId(Long idAtividadeEscolha);

}

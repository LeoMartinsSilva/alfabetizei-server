package br.app.alfabetizei.repository.atividadePai;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.alfabetizei.model.atividadePai.AtividadePaiSugestaoLeitura;

public interface AtividadePaiSugestaoLeituraRepository extends JpaRepository<AtividadePaiSugestaoLeitura, Long> {

	List<AtividadePaiSugestaoLeitura> findAllByAtividadePaiId(Long idAtividade);

}

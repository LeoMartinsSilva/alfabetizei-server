package br.app.alfabetizei.repository.atividadePai;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.alfabetizei.model.atividadePai.AtividadePaiSugestaoVideo;

public interface AtividadePaiSugestaoVideoRepository extends JpaRepository<AtividadePaiSugestaoVideo, Long> {

	List<AtividadePaiSugestaoVideo> findAllByAtividadePaiId(Long idAtividade);

}

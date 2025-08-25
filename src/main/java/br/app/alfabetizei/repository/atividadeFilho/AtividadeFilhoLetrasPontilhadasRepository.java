package br.app.alfabetizei.repository.atividadeFilho;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoLetrasPontilhadas;

public interface AtividadeFilhoLetrasPontilhadasRepository extends JpaRepository<AtividadeFilhoLetrasPontilhadas, Long> {

	List<AtividadeFilhoLetrasPontilhadas> findAllByAtividadeFilhoId(Long idAtividade);

}

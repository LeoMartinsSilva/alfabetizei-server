package br.app.alfabetizei.service.atividadeFilho;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoEscolhaOpcaoUsuarioDto;
import br.app.alfabetizei.mapper.atividadeFilho.AtividadeFilhoEscolhaOpcaoUsuarioMapper;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoEscolhaOpcao;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoEscolhaOpcaoUsuario;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoEscolhaUsuario;
import br.app.alfabetizei.repository.atividadeFilho.AtividadeFilhoEscolhaOpcaoRepository;
import br.app.alfabetizei.repository.atividadeFilho.AtividadeFilhoEscolhaOpcaoUsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class AtividadeFilhoEscolhaOpcaoService {
	
	@Autowired
	private AtividadeFilhoEscolhaOpcaoRepository repository;
	
	@Autowired
	private AtividadeFilhoEscolhaOpcaoUsuarioRepository atividadeFilhoEscolhaOpcaoUsuarioRepository;
	
	@Autowired
	private AtividadeFilhoEscolhaOpcaoUsuarioMapper atividadeFilhoEscolhaOpcaoUsuarioMapper;
	
	
	@Transactional
	public List<AtividadeFilhoEscolhaOpcaoUsuarioDto> buscarPorAtividadeId(AtividadeFilhoEscolhaUsuario atividadeFilhoEscolhaUsuario, Long idAtividadeEscolha){
		List<AtividadeFilhoEscolhaOpcaoUsuarioDto> itensUsuario = atividadeFilhoEscolhaOpcaoUsuarioMapper.toDto(atividadeFilhoEscolhaOpcaoUsuarioRepository.findAllByAtividadeFilhoEscolhaUsuarioIdOrderBySequencial(atividadeFilhoEscolhaUsuario.getId()));
		if(itensUsuario.size() == 0) {
			List<AtividadeFilhoEscolhaOpcao> itens = repository.findAllByAtividadeFilhoEscolhaId(idAtividadeEscolha);
			for(AtividadeFilhoEscolhaOpcao item : itens) {
				AtividadeFilhoEscolhaOpcaoUsuario itemUsuario = new AtividadeFilhoEscolhaOpcaoUsuario();
				itemUsuario.setAtividadeFilhoEscolhaUsuario(atividadeFilhoEscolhaUsuario);
				itemUsuario.setSequencial(item.getSequencial());
				itemUsuario.setOpcaoCorreta(item.getOpcaoCorreta());
				itemUsuario.setDescricao(item.getDescricao());
				itemUsuario = atividadeFilhoEscolhaOpcaoUsuarioRepository.save(itemUsuario);
				itensUsuario.add(atividadeFilhoEscolhaOpcaoUsuarioMapper.toDto(itemUsuario));
			}
		}
		
		return itensUsuario;
	}


	@Transactional
	public void marcarComoEscolhida(Long id) {
		Optional<AtividadeFilhoEscolhaOpcaoUsuario> optional = atividadeFilhoEscolhaOpcaoUsuarioRepository.findById(id);
		if(optional.isPresent()) {
			AtividadeFilhoEscolhaOpcaoUsuario opcao = optional.get();
			opcao.setOpcaoEscolhida(true);
		}
		
	}
}

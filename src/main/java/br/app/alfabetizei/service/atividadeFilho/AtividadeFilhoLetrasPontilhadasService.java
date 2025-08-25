package br.app.alfabetizei.service.atividadeFilho;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.alfabetizei.dto.atividadeFilho.AtividadeFilhoLetrasPontilhadasUsuarioDto;
import br.app.alfabetizei.dto.atividadeFilho.responder.AtividadeLetrasPontilhadasResponderDto;
import br.app.alfabetizei.mapper.atividadeFilho.AtividadeFilhoLetrasPontilhadasUsuarioMapper;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoLetrasPontilhadas;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoLetrasPontilhadasUsuario;
import br.app.alfabetizei.model.atividadeFilho.AtividadeFilhoUsuario;
import br.app.alfabetizei.repository.atividadeFilho.AtividadeFilhoLetrasPontilhadasRepository;
import br.app.alfabetizei.repository.atividadeFilho.AtividadeFilhoLetrasPontilhadasUsuarioRepository;
import br.app.alfabetizei.service.UsuarioLogadoService;
import jakarta.transaction.Transactional;

@Service
public class AtividadeFilhoLetrasPontilhadasService {
	
	@Autowired
	private AtividadeFilhoLetrasPontilhadasRepository repository;
	
	@Autowired
	private AtividadeFilhoLetrasPontilhadasUsuarioRepository atividadeFilhoLetrasPontilhadasUsuarioRepository;
	
	@Autowired
	private AtividadeFilhoLetrasPontilhadasUsuarioMapper atividadeFilhoLetrasPontilhadasUsuarioMapper;
	
	@Autowired
	private UsuarioLogadoService usuarioLogadoService;
	
	@Transactional
	public List<AtividadeFilhoLetrasPontilhadasUsuarioDto> buscarPorAtividade(AtividadeFilhoUsuario atividadeFilhoUsuario){
		List<AtividadeFilhoLetrasPontilhadasUsuarioDto> itensUsuario = atividadeFilhoLetrasPontilhadasUsuarioMapper.toDto(atividadeFilhoLetrasPontilhadasUsuarioRepository.findAllByAtividadeFilhoUsuarioIdOrderBySequencial(atividadeFilhoUsuario.getId()));
		if(itensUsuario.size() == 0) {
			List<AtividadeFilhoLetrasPontilhadas> itens = repository.findAllByAtividadeFilhoId(atividadeFilhoUsuario.getAtividadeFilho().getId());
			for(AtividadeFilhoLetrasPontilhadas item : itens) {
				AtividadeFilhoLetrasPontilhadasUsuario itemUsuario = new AtividadeFilhoLetrasPontilhadasUsuario();
				itemUsuario.setAtividadeFilhoUsuario(atividadeFilhoUsuario);
				itemUsuario.setLetras(item.getLetras());
				itemUsuario.setSequencial(item.getSequencial());
				itemUsuario = atividadeFilhoLetrasPontilhadasUsuarioRepository.save(itemUsuario);
				itensUsuario.add(atividadeFilhoLetrasPontilhadasUsuarioMapper.toDto(itemUsuario));
			}
		}
		return itensUsuario;
	}

	@Transactional
	public void responder(AtividadeLetrasPontilhadasResponderDto dados) {
		Long idUsuario = usuarioLogadoService.getUsuarioLogado().getId();
		
		Optional<AtividadeFilhoLetrasPontilhadasUsuario> optional = atividadeFilhoLetrasPontilhadasUsuarioRepository.findById(dados.getIdAtividadeFilhoLetrasPontilhadasUsuario());
		if(optional.isPresent()) {
			AtividadeFilhoLetrasPontilhadasUsuario item = optional.get();
			if(!idUsuario.equals(item.getAtividadeFilhoUsuario().getUsuario().getId())) {
				throw new RuntimeException("Essa atividade não pertence ao seu usuário");
			}
			item.setDesenhoBase64(dados.getDesenhoBase64());
		}
		
	}
}

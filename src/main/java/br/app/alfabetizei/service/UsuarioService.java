package br.app.alfabetizei.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.alfabetizei.dto.UsuarioCriarDto;
import br.app.alfabetizei.dto.UsuarioDto;
import br.app.alfabetizei.mapper.UsuarioMapper;
import br.app.alfabetizei.model.Usuario;
import br.app.alfabetizei.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioMapper mapper;
	
	@Autowired
	private UsuarioLogadoService usuarioLogadoService;
	
	public UsuarioDto criar(UsuarioCriarDto dados) {
		Usuario usuario = Usuario.builder().modeloCelular(dados.getModeloCelular()).build();
		usuario.setUuid(UUID.randomUUID().toString().replace("-", ""));
		usuario = repository.save(usuario);
		return mapper.toDto(usuario);
	}

	@Transactional
	public UsuarioDto atualizar(UsuarioDto dados) {
		if(usuarioLogadoService.getUsuarioLogado()!=null) {
			Optional<Usuario> optional = repository.findById(usuarioLogadoService.getUsuarioLogado().getId());
			if(optional.isPresent()) {
				Usuario usuario = optional.get();
				usuario.setNome(dados.getNome());
				usuario.setNomeMae(dados.getNomeMae());
				usuario.setNomePai(dados.getNomePai());
				return mapper.toDto(usuario);
			}
		}
		return null;
	}
}

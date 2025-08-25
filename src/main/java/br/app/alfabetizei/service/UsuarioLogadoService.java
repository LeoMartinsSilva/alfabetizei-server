package br.app.alfabetizei.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.app.alfabetizei.model.Usuario;

@Service
public class UsuarioLogadoService {
	public Usuario getUsuarioLogado() {
		return (Usuario) SecurityContextHolder
		        .getContext()
		        .getAuthentication()
		        .getPrincipal();
	}
}

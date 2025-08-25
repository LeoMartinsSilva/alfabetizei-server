package br.app.alfabetizei.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.app.alfabetizei.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByUuid(String token);

}

package br.app.alfabetizei.mapper;

import org.springframework.stereotype.Component;

@Component
public interface EntityMapper<D, E> {

	E toEntity(D dto);

	D toDto(E entity);

}

package com.w2m.superheroes.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.w2m.superheroes.entity.SuperHeroeEntity;
import com.w2m.superheroes.model.SuperHeroe;

@Component
public class SuperHeroeConverter {

	public SuperHeroeEntity dtoToEntity(SuperHeroe superHeroe) {
		return SuperHeroeEntity.builder().name(superHeroe.getName()).comment(superHeroe.getName()).build();

	}

	public SuperHeroe entityToDto(SuperHeroeEntity superHeroeEntity) {
		var superHeroe = new SuperHeroe();
		superHeroe.setId(new StringBuilder().append(superHeroeEntity.getId()).toString());
		superHeroe.setName(superHeroeEntity.getName());
		superHeroe.setComment(superHeroeEntity.getComment());
		return superHeroe;
	}

	public List<SuperHeroe> entitiesToDtos(List<SuperHeroeEntity> entities) {
		var dtos = new ArrayList<SuperHeroe>();
		entities.stream().forEach((e) -> {
			dtos.add(entityToDto(e));
		});
		return dtos;
	}

}

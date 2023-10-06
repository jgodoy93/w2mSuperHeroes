package com.w2m.superheroes.converter;

import com.w2m.superheroes.entity.SuperHeroeEntity;
import com.w2m.superheroes.model.CreateSuperHeroe;
import com.w2m.superheroes.model.SuperHeroe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SuperHeroeConverter {

    public SuperHeroeEntity dtoToEntity(CreateSuperHeroe createSuperHeroe) {
        var entity = new SuperHeroeEntity();
        entity.setName(createSuperHeroe.getName());
        entity.setComment(createSuperHeroe.getComment());
        return entity;
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

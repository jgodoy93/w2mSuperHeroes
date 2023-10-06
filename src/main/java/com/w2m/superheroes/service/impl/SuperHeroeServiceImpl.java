package com.w2m.superheroes.service.impl;

import com.w2m.superheroes.model.CreateSuperHeroe;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.w2m.superheroes.converter.SuperHeroeConverter;
import com.w2m.superheroes.model.SuperHeroe;
import com.w2m.superheroes.model.SuperHeroes;
import com.w2m.superheroes.repository.SuperHeroeRepository;
import com.w2m.superheroes.service.SuperHeroeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class SuperHeroeServiceImpl implements SuperHeroeService {

	private final SuperHeroeRepository superHeroeRepository;
	private final SuperHeroeConverter superHeroeConverter;

	@Override
	@CacheEvict(value = "superheroes", allEntries = true)
	public SuperHeroe createSuperHeroe(CreateSuperHeroe createSuperHeroe) {
		log.info("::: Creating super Heroe :::");
		var created = superHeroeRepository.save(superHeroeConverter.dtoToEntity(createSuperHeroe));
		log.info("::: {} is created!", createSuperHeroe.getName());
		return superHeroeConverter.entityToDto(created);
	}

	@Override
	@CachePut(value = "superheroes")
	public SuperHeroe updateSuperHeroe(SuperHeroe superHeroe) {
		var edit = superHeroeRepository.findById(Long.parseLong(superHeroe.getId())).orElseThrow(() -> {
			log.info("::: SuperHeroe not found with id: {} :::", superHeroe.getId());
			return new ResponseStatusException(HttpStatus.NOT_FOUND, "SuperHeroe not found.");
		});
		edit.setName(superHeroe.getName());
		edit.setComment(superHeroe.getComment());
		superHeroeRepository.save(edit);
		return superHeroe;
	}

	@Override
	public SuperHeroe getSuperHeroeById(String id) {
		log.info("::: Searching super Heroe with id: {} :::", id);
		var superHeroe = superHeroeRepository.findById(Long.parseLong(id)).orElseThrow(() -> {
			log.info("::: SuperHeroe not found with id: {} :::", id);
			return new ResponseStatusException(HttpStatus.NOT_FOUND, "SuperHeroe not found.");
		});
		log.info("::: Super hero found! :::");
		return superHeroeConverter.entityToDto(superHeroe);
	}

	@Override
	@Cacheable("superheroes")
	public SuperHeroes findAllSuperHeroes() {
		log.info("::: Searching All SuperHeroes :::");
		var superHeroes = new SuperHeroes();
		var result = superHeroeRepository.findAll();
		if (result.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found superheroes in database");
		}
		superHeroes.setData(superHeroeConverter.entitiesToDtos(result));
		return superHeroes;
	}

	@Override
	public SuperHeroes findAllSuperHeroesBySearchCriteria(String search) {
		log.info("::: Looking for all the superheroes that its name contains {} :::", search);
		var superHeroes = new SuperHeroes();
		var result = superHeroeRepository.findByNameContaining(search);
		if (result.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No superhero names found that contain " + search);
		}
		superHeroes.setData(superHeroeConverter.entitiesToDtos(result.get()));
		return superHeroes;
	}

	@Override
	public void deleteSuperHeroe(String id) {
		log.info("::: Deleting superhero with id {} :::", id);
		var entity = superHeroeRepository.findById(Long.parseLong(id)).orElseThrow(() -> {
			log.info("::: SuperHeroe not found with id: {} :::", id);
			return new ResponseStatusException(HttpStatus.NOT_FOUND, "SuperHeroe not found.");
		});
		superHeroeRepository.delete(entity);
		log.info("::: Superhero removed :::");
	}

}

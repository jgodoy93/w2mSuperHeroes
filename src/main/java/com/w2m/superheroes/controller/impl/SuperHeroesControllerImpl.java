package com.w2m.superheroes.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.w2m.superheroes.api.SuperheroeApi;
import com.w2m.superheroes.model.SuperHeroe;
import com.w2m.superheroes.model.SuperHeroes;
import com.w2m.superheroes.service.impl.SuperHeroeServiceImpl;
import com.w2m.superheroes.utils.ResponseSpeed;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SuperHeroesControllerImpl implements SuperheroeApi {

	private final SuperHeroeServiceImpl superHeroeServiceImpl;

	@Override
	public ResponseEntity<SuperHeroe> createSuperHeroe(SuperHeroe superHeroe) {
		return new ResponseEntity<SuperHeroe>(superHeroeServiceImpl.createSuperHeroe(superHeroe), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Void> deleteSuperHeroe(String id) {
		superHeroeServiceImpl.deleteSuperHeroe(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	@ResponseSpeed
	public ResponseEntity<SuperHeroes> findAllSuperheroes() {
		return new ResponseEntity<SuperHeroes>(superHeroeServiceImpl.findAllSuperHeroes(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<SuperHeroes> findAllSuperheroesBySearchCriteria(String search) {
		return new ResponseEntity<SuperHeroes>(superHeroeServiceImpl.findAllSuperHeroesBySearchCriteria(search),
				HttpStatus.OK);
	}

	@Override
	public ResponseEntity<SuperHeroe> findSuperheroeById(String id) {
		return new ResponseEntity<SuperHeroe>(superHeroeServiceImpl.getSuperHeroeById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<SuperHeroe> modifySuperHeroe(SuperHeroe superHeroe) {
		return new ResponseEntity<SuperHeroe>(superHeroeServiceImpl.updateSuperHeroe(superHeroe), HttpStatus.OK);
	}

}

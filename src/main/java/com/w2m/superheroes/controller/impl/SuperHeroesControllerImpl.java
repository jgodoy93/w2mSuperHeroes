package com.w2m.superheroes.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.w2m.superheroes.api.SuperheroeApi;
import com.w2m.superheroes.model.SuperHeroe;
import com.w2m.superheroes.model.SuperHeroes;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SuperHeroesControllerImpl implements SuperheroeApi  {

	@Override
	public ResponseEntity<SuperHeroe> createSuperHeroe(SuperHeroe superHeroe){
		return new ResponseEntity<SuperHeroe>(HttpStatus.OK);
	}
	
	
	@Override
	public ResponseEntity<Void> deleteSuperHeroe(String id){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@Override
	public ResponseEntity<SuperHeroes> findAllSuperheroes(){
		return new ResponseEntity<SuperHeroes>(HttpStatus.OK);
	}
	
	
	@Override
	public ResponseEntity<SuperHeroe> findSuperheroeById(String id){
		return new ResponseEntity<SuperHeroe>(HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<SuperHeroe> modifySuperHeroe(SuperHeroe superHeroe){
		return new ResponseEntity<SuperHeroe>(HttpStatus.OK);
	}
	
	
	
	
	
}

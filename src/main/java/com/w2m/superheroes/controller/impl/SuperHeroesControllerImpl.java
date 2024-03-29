package com.w2m.superheroes.controller.impl;

import com.w2m.superheroes.controller.SuperHeroesController;
import com.w2m.superheroes.model.CreateSuperHeroe;
import com.w2m.superheroes.model.SuperHeroe;
import com.w2m.superheroes.model.SuperHeroes;
import com.w2m.superheroes.service.impl.SuperHeroeServiceImpl;
import com.w2m.superheroes.utils.ResponseSpeed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SuperHeroesControllerImpl implements SuperHeroesController {

    private final SuperHeroeServiceImpl superHeroeServiceImpl;

    @Override
    public ResponseEntity<SuperHeroe> createSuperHeroe(CreateSuperHeroe createSuperHeroe) {
        return new ResponseEntity<SuperHeroe>(superHeroeServiceImpl.createSuperHeroe(createSuperHeroe), HttpStatus.CREATED);
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

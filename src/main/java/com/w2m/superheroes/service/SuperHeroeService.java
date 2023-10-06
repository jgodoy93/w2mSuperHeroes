package com.w2m.superheroes.service;

import com.w2m.superheroes.model.CreateSuperHeroe;
import com.w2m.superheroes.model.SuperHeroe;
import com.w2m.superheroes.model.SuperHeroes;

public interface SuperHeroeService {

	SuperHeroe createSuperHeroe(CreateSuperHeroe createSuperHeroe);

	SuperHeroe updateSuperHeroe(SuperHeroe superHeroe);

	SuperHeroe getSuperHeroeById(String id);

	SuperHeroes findAllSuperHeroes();

	SuperHeroes findAllSuperHeroesBySearchCriteria(String search);

	void deleteSuperHeroe(String id);

}

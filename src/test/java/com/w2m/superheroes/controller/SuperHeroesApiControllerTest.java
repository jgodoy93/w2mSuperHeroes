package com.w2m.superheroes.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.w2m.superheroes.controller.impl.SuperHeroesControllerImpl;
import com.w2m.superheroes.model.SuperHeroe;
import com.w2m.superheroes.utils.TestUtils;

@WebMvcTest
@RunWith(SpringRunner.class)
public class SuperHeroesApiControllerTest {

	@InjectMocks
	private SuperHeroesControllerImpl superHeroeControllerImpl;

	@Mock
	SuperHeroeServiceImpl superHeroeServiceImpl;

	@DisplayName("Integration test for Create Super Heroe")
	@Test
	public void createSuperHeroe() throws Exception {
		var dto = TestUtils.buildSuperHeroe();
		doReturn(dto).when(superHeroeServiceImpl).createSuperHeroe(dto);
		ResponseEntity<SuperHeroe> response = superHeroeControllerImpl.createSuperHeroe(dto);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertNotNull(response.getBody());
	}

	@DisplayName("Integration test for delete Super Heroe")
	@Test
	public void deleteSuperHeroe() throws Exception {

	}

	@DisplayName("Integration test for FindAll Super Heroe")
	@Test
	public void findAllSuperHeroes() throws Exception {

	}

	@DisplayName("Integration test for FindSuperHeroeById Super Heroe")
	@Test
	public void findSuperHeroeById() throws Exception {
		var dto = TestUtils.buildSuperHeroe2();
		doReturn(dto).when(superHeroeServiceImpl).getSuperHeroeById("2");
		ResponseEntity<SuperHeroe> response = superHeroeControllerImpl.findSuperheroeById("2");
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());

	}

	@DisplayName("Integration test for Modify Super Heroe")
	@Test
	public void modifySuperHeroe() throws Exception {

	}

	@DisplayName("Integration test for findAllSuperHeroesByCriteria Super Heroe")
	@Test
	public void findAllSuperheroesBySearchCriteria() throws Exception {

	}

}

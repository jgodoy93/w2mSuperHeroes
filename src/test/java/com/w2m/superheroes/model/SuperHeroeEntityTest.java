package com.w2m.superheroes.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.w2m.superheroes.entity.SuperHeroeEntity;

public class SuperHeroeEntityTest {

	@DisplayName("Test for entity SuperHeroeEntity")
	@Test
	void testSuperHeroeEntity() {
		SuperHeroeEntity superHeroeEntity = new SuperHeroeEntity();

		superHeroeEntity.setId(1L);
		superHeroeEntity.setName("TestSuperHeroe");
		superHeroeEntity.setComment("Un heroe de mentira");

		assertEquals(1L, superHeroeEntity.getId());
		assertEquals("TestSuperHeroe", superHeroeEntity.getName());
		assertEquals("Un heroe de mentira", superHeroeEntity.getComment());
	}

}

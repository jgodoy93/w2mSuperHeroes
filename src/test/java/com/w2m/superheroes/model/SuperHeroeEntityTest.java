package com.w2m.superheroes.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SuperHeroeEntityTest {
	
	@DisplayName("Test for entity SuperHeroeEntity")
	@Test
	void testSuperHeroeEntity() {
		SuperHeroeEntity superHeroeEntity = new SuperHeroeEntity();
		
		superHeroeEntity.setId(1);
		superHeroeEntity.setName("TestSuperHeroe");
		superHeroeEntity.setComment("Un heroe de mentira");
		
		assertEquals(1,superHeroeEntity.getId());
		assertEquals("TestSuperHeroe",superHeroeEntity.getName());
		assertEquals("Un heroe de mentira",superHeroeEntity.getComment());
	}
	
	

}

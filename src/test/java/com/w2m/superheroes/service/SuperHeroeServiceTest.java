package com.w2m.superheroes.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.w2m.superheroes.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
class SuperHeroeServiceTest {

	private static final String SEARCH = "Test";

	@InjectMocks
	private SuperHeroeServiceImpl superHeroeServiceImpl;

	@Mock
	private SuperHeroeRepository superHeroeRepository;

	@Mock
	private SuperHeroeConverter superHeroeConverter;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		superHeroeDTO = TestUtils.buildSuperHeroe();
		superHeroeEntity = TestUtils.buildSuperHeroeEntity();
		superHeroeEntity2 = TestUtils.buildSuperHeroeEntity2();

	}

	@DisplayName("Test for createSuperHeroe")
	@Test
	void createSuperHeroeTest() {

		doReturn(superHeroeEntity).when(superHeroeConverter).dtoToEntity(superHeroeDTO);
		doReturn(superHeroeEntity).when(superHeroeRepository).save();

		var result = superHeroeServiceImpl.createSuperHeroe(superHeroeEntity);

		assertNotNull(result);
		assertEquals(1, superHeroeEntity.getId());
		assertEquals("TestSuperHeroe", superHeroeEntity.getName());
		assertEquals("Un heroe de mentira", superHeroeEntity.getComment());

	}

	@DisplayName("Test for updateSuperHeroe")
	@Test
	void updateSuperHeroeTest() {

		var superHeroeDTOAlt = TestUtils.buildSuperHeroe2();

		doReturn(Optional.of(superHeroeEntity)).when(superHeroeRepository).findById(superHeroeDTOAlt.getId());
		doReturn(superHeroeEntity).when(superHeroeRepository).save(superHeroeEntity);

		var result = superHeroeServiceImpl.updateSuperHeroe(superHeroeDTOAlt);

		assertNotNull(result);
		assertEquals(result.getName(), superHeroeDTOAlt.getName());
		assertEquals(result.getComment(), superHeroeDTOAlt.getComment());

	}

	@DisplayName("Test for get SuperHeroe")
	@Test
	void getSuperHeroeTest() {

		doReturn(Optional.of(superHeroeEntity)).when(superHeroeRepository).findById(1);
		doReturn(superHeroeDTO).when(superHeroeConverter).entityToDto(superHeroeEntity);

		var result = superHeroeServiceImpl.getSuperHeroeById(1);

		assertEquals(1, superHeroeEntity.getId());
		assertEquals("TestSuperHeroe", superHeroeEntity.getName());
		assertEquals("Un heroe de mentira", superHeroeEntity.getComment());

	}

	@DisplayName("Test for findAllSuperHeroesbySearchCriteria")
	@Test
	void findAllSuperHeroesByCriteria() {
		doReturn(Optional.of(TestUtils.buildListSuperHeroes())).when(superHeroeRepository).findByNameContaining(SEARCH);
		doReturn(TestUtils.buildListSuperHeroeDTO()).when(superHeroeConverter).entitiesToDtos(List<SuperHeroeEntity>);
		
		var result = superHeroeServiceImpl.findAllSuperHeroesBySearchCriteria(SEARCH);
		
		assertNotNull(result);
		
		result.stream().forEach((d) ->{
			assertTrue(StringUtils.contains(d.getName(),SEARCH));
		});

	}

	@DisplayName("Test for delete SuperHeroe")
	@Test
	void deleteSuperHeroe() {

		doReturn(Optional.of(superHeroeEntity2)).when(superHeroeRepository).findById(2);
		superHeroeServiceImpl.deleteSuperHeroe(2);

		verify(superHeroeRepository).delete(superHeroeEntity2);

	}

	@DisplayName("Test for exception")
	@Test
	void exceptionTest() {
		
		doThrow(new ResponseStatusException(HttpStatus.NOT_FOUND),"SuperHeroe not found")).when(superHeroeRepository).findById(1);
		
		assertThrows(ResponseStatusException.class, ()-> {
			superHeroeServiceImpl.getSuperHeroeById(1);
		});
		
	}

}
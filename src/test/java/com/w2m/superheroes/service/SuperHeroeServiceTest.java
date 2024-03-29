package com.w2m.superheroes.service;

import com.w2m.superheroes.converter.SuperHeroeConverter;
import com.w2m.superheroes.entity.SuperHeroeEntity;
import com.w2m.superheroes.model.CreateSuperHeroe;
import com.w2m.superheroes.model.SuperHeroe;
import com.w2m.superheroes.repository.SuperHeroeRepository;
import com.w2m.superheroes.service.impl.SuperHeroeServiceImpl;
import com.w2m.superheroes.utils.TestUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class SuperHeroeServiceTest {

    private static final String SEARCH = "Test";
    public SuperHeroe superHeroeDTO;
    public CreateSuperHeroe createSuperHeroeDTO;
    public SuperHeroeEntity superHeroeEntity;
    public SuperHeroeEntity superHeroeEntity2;

    @InjectMocks
    private SuperHeroeServiceImpl superHeroeServiceImpl;

    @Mock
    private SuperHeroeRepository superHeroeRepository;

    @Mock
    private SuperHeroeConverter superHeroeConverter;

    @Before()
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    void setup() {
        createSuperHeroeDTO = TestUtils.buildCreateSuperHeroe();
        superHeroeDTO = TestUtils.buildSuperHeroe();
        superHeroeEntity = TestUtils.buildSuperHeroeEntity();
        superHeroeEntity2 = TestUtils.buildSuperHeroeEntity2();
    }

    @DisplayName("Test for updateSuperHeroe")
    @Test
    void updateSuperHeroeTest() {

        SuperHeroe superHeroeDTOAlt = TestUtils.buildSuperHeroe2();

        doReturn(Optional.of(superHeroeEntity2)).when(superHeroeRepository).findById(2L);
        doReturn(superHeroeEntity2).when(superHeroeRepository).save(superHeroeEntity2);

        SuperHeroe result = superHeroeServiceImpl.updateSuperHeroe(superHeroeDTOAlt);

        assertNotNull(result);
        assertEquals(result.getName(), superHeroeDTOAlt.getName());
        assertEquals(result.getComment(), superHeroeDTOAlt.getComment());

    }

    @DisplayName("Test for get SuperHeroe")
    @Test
    void getSuperHeroeTest() {

        doReturn(Optional.of(superHeroeEntity)).when(superHeroeRepository).findById(1L);
        doReturn(superHeroeDTO).when(superHeroeConverter).entityToDto(superHeroeEntity);

        SuperHeroe result = superHeroeServiceImpl.getSuperHeroeById("1");

        assertEquals("1", result.getId());
        assertEquals("TestSuperHeroe", result.getName());
        assertEquals("Un heroe de mentira", result.getComment());

    }

    @DisplayName("Test for findAllSuperHeroesbySearchCriteria")
    @Test
    void findAllSuperHeroesByCriteria() {
        doReturn(Optional.of(TestUtils.buildListSuperHeroes())).when(superHeroeRepository).findByNameContaining(SEARCH);
        doReturn(TestUtils.buildListSuperHeroeDTO()).when(superHeroeConverter)
                .entitiesToDtos(TestUtils.buildListSuperHeroes());

        var result = superHeroeServiceImpl.findAllSuperHeroesBySearchCriteria(SEARCH);

        assertNotNull(result);

        result.getData().stream().forEach((d) -> {
            assertTrue(StringUtils.contains(d.getName(), SEARCH));
        });

    }

    @DisplayName("Test for delete SuperHeroe")
    @Test
    void deleteSuperHeroe() {

        doReturn(Optional.of(superHeroeEntity2)).when(superHeroeRepository).findById(2L);
        superHeroeServiceImpl.deleteSuperHeroe("2");

        verify(superHeroeRepository).delete(superHeroeEntity2);

    }

    @DisplayName("Test for createSuperHeroe")
    @Test
    void createSuperHeroeTest() {
        doReturn(Optional.empty()).when(superHeroeRepository).findByName("TestSuperHeroe");
        doReturn(superHeroeEntity).when(superHeroeConverter).dtoToEntity(createSuperHeroeDTO);
        doReturn(superHeroeEntity).when(superHeroeRepository).save(any(SuperHeroeEntity.class));
        doReturn(superHeroeDTO).when(superHeroeConverter).entityToDto(superHeroeEntity);

        SuperHeroe result = superHeroeServiceImpl.createSuperHeroe(createSuperHeroeDTO);
        assertEquals("TestSuperHeroe", result.getName());
        assertEquals("Un heroe de mentira", result.getComment());

        verify(superHeroeRepository, times(1)).findByName("TestSuperHeroe");
        verify(superHeroeConverter, times(1)).dtoToEntity(createSuperHeroeDTO);
        verify(superHeroeRepository, times(1)).save(any(SuperHeroeEntity.class));

        assertNotNull(result);
    }

    @DisplayName("Test for createSuperHeroe when exists")
    @Test
    void createSuperHeroeTestWhenExists() {

        doReturn(Optional.of(superHeroeEntity)).when(superHeroeRepository).findByName("TestSuperHeroe");

        assertThrows(ResponseStatusException.class, () -> {
            superHeroeServiceImpl.createSuperHeroe(createSuperHeroeDTO);
        });

        verifyZeroInteractions(superHeroeConverter);
        verifyZeroInteractions(superHeroeRepository);
    }

    @DisplayName("Test for exception")
    @Test
    void exceptionTest() {

        doThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "SuperHeroe not found.")).when(superHeroeRepository)
                .findById(1L);
        assertThrows(ResponseStatusException.class, () -> {
            superHeroeServiceImpl.getSuperHeroeById("1");
        });

    }

}






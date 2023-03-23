package com.w2m.superheroes.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TemplateBSServiceImplTest {
	/*
    public static final String CATEGORY_NAME = "Category1";
    public static final String CATEGORY_DESCRIPTION = "category description";
    public CategoryDTO categoryDTO;
    public CategoryEntity categoryEntity;

    @InjectMocks
    TemplateDBServiceImpl templateDBServiceImpl;

    @Mock
    CategoryConverter categoryConverter;

    @Mock
    CategoryRepository categoryRepository;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        categoryDTO = TestUtils.buildCategoryDTO();
        categoryEntity = TestUtils.buildCategoryEntity();
    }

    @DisplayName("Test for Add Category")
    @Test
    public void addCategoryTest() {

        doReturn(categoryEntity).when(categoryConverter).dtoToEntity(categoryDTO);
        doReturn(categoryEntity).when(categoryRepository).save(categoryEntity);

        var result = templateDBServiceImpl.addCategory(categoryDTO);

        assertNotNull(result);
        assertEquals(result.getName(), CATEGORY_NAME);
        assertEquals(result.getDescription(), CATEGORY_DESCRIPTION);

    }

    @DisplayName("Test for get Category")
    @Test()
    public void getCategoryTest() {

        doReturn(Optional.of(categoryEntity)).when(categoryRepository).findById(1L);
        doReturn(categoryDTO).when(categoryConverter).entityToDto(categoryEntity);

        var result = templateDBServiceImpl.getCategory(1L);

        assertNotNull(result);
        assertEquals(result.getName(), CATEGORY_NAME);
        assertEquals(result.getDescription(), CATEGORY_DESCRIPTION);

    }

    @DisplayName("Test for put Category")
    @Test
    public void putCategoryTest() {

        var categoyDTOAlt = CategoryDTO.builder().name("Category Name2").description("Description 2").build();

        doReturn(Optional.of(categoryEntity)).when(categoryRepository).findById(1L);
        doReturn(categoryEntity).when(categoryRepository).save(categoryEntity);

        var result = templateDBServiceImpl.putCategory(1L, categoyDTOAlt);

        assertNotNull(result);
        assertEquals(result.getName(), "Category Name2");
        assertEquals(result.getDescription(), "Description 2");

    }

    @DisplayName("Test for delete Category")
    @Test
    public void deleteCategoryTest() {

        var auxEntity = CategoryEntity.builder().id(2L).name("Aux Category").description("Aux Description").build();

        doReturn(Optional.of(auxEntity)).when(categoryRepository).findById(2L);

        templateDBServiceImpl.deleteCategory(2l);

        verify(categoryRepository).delete(auxEntity);

    }

    @DisplayName("Test for exception")
    @Test
    public void exceptionTest() {

        doThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not Found.")).when(categoryRepository)
                .findById(1L);

        assertThrows(ResponseStatusException.class, () -> {
            templateDBServiceImpl.getCategory(1L);
        });

    }
    
    */

}

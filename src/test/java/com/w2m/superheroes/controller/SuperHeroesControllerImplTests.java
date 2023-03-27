package com.w2m.superheroes.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.w2m.superheroes.utils.TestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SuperHeroesControllerImplTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private ObjectMapper objectMapper;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}

	@DisplayName("Integration test for create SuperHeroe")
	@WithMockUser("w2mTest")
	@Test
	public void testCreateSuperHeroe() throws Exception {

		var jsonRequest = objectMapper.writeValueAsString(TestUtils.buildSuperHeroeEntity());

		var result = mockMvc.perform(post("/superheroe").contentType(MediaType.APPLICATION_JSON).content(jsonRequest))
				.andExpect(status().isCreated()).andReturn();
		assertNotNull(result);
		assertEquals(201, result.getResponse().getStatus());
	}

	@DisplayName("Integration test for find All SuperHeroes")
	@WithMockUser("w2mTest")
	@Test
	public void testFindAllSuperHeroes() throws Exception {

		var result = mockMvc.perform(get("/superheroes")).andExpect(status().isOk()).andReturn();

		assertNotNull(result);
		assertEquals(200, result.getResponse().getStatus());
	}

	@DisplayName("Integration test for findSuperHeroeById")
	@WithMockUser("w2mTest")
	@Test
	public void testFindSuperHeroeById() throws Exception {

		var result = mockMvc.perform(get("/superheroe/{id}", 1)).andExpect(status().isOk()).andReturn();
		assertNotNull(result);
		assertEquals(200, result.getResponse().getStatus());
	}

}

package com.w2m.superheroes;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.w2m.superheroes.config.SwaggerConfig;

@SpringBootTest
@Import(SwaggerConfig.class)
@AutoConfigureMockMvc
class SwaggerAPIIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void swaggerJsonExists() throws Exception {
        String contentAsString = mockMvc
                .perform(MockMvcRequestBuilders.get("/v2/api-docs").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        try (Writer writer = new FileWriter(new File("target/generated-sources/swagger.json"))) {
            IOUtils.write(contentAsString, writer);
        }
    }

}

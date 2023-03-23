package com.w2m.superheroes.config;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Set<String> DEFAULT_PRODUCES = new HashSet<>(Collections.singletonList("application/json"));
    private static final String PATH_ERROR = "(?!/error).+";
    private static final String PATH_MANAGE = "(?!/manage).+";
    private static final String TAG_NAME = "Template";
    private static final String TAG_DESCRIPTION = "All resources available for Template microservice";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).produces(DEFAULT_PRODUCES).useDefaultResponseMessages(false)
                .select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.regex(PATH_ERROR))
                .paths(PathSelectors.regex(PATH_MANAGE)).build().apiInfo(getApiInfo())
                .tags(new Tag(TAG_NAME, TAG_DESCRIPTION));
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo("SuperHeroes API", "SuperHeroes API", "2.0", null, null, null, null, Collections.emptyList());
    }

}

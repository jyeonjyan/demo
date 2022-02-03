package com.app.demo.demo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI demoOpenAPI(){
        return new OpenAPI()
                .info(
                        new Info()
                        .title("demo API")
                        .description("Fast Spring Application Starter")
                        .version("v0.0.1")
                        .license(new License().name("MIT License").url("https://github.com/jyeonjyan/springboot-starter"))
                )
                .externalDocs(
                        new ExternalDocumentation()
                        .description("demo Wiki Documentation")
                );
    }

    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("springboot-demo")
                .pathsToMatch("/v1/api/demo/**")
                .build();
    }

}

package com.beautyfullcare.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Beautyfull Care API")
                        .version("1.0")
                        .description("API documentation for Beautyfull Care application")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}

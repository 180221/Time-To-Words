package org.wisleaf.com.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {
    @Bean
    public OpenAPI SwaggerAPI() {
        return new OpenAPI()
                .info(new Info() .title("Time-To-Words Request API")
                        .version("1.0")
                        .description("API for converting time to words"));
    }
}

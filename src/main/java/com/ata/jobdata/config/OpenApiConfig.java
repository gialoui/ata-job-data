package com.ata.jobdata.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI apiDoc() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Job Data APIs")
                                .description("API document of Job Data Service")
                                .version("v0.0.1")
                                .license(new License().name("ATA IT TH")));
    }
}

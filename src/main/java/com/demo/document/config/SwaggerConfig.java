package com.demo.document.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI documentIngestionOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Document Ingestion and Q&A API")
                        .description("Spring Boot backend for uploading, storing and querying documents")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Dillip Giri")
                                .email("dillip008@google.com")
                                .url("https://dillip-giri.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                .externalDocs(new ExternalDocumentation()
                        .description("Project Documentation")
                        .url("https://github.com/your-repo"));
    }
}

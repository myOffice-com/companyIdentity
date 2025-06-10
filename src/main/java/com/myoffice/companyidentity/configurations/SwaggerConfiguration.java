package com.myoffice.companyidentity.configurations;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * SwaggerConfiguration class provides the OpenAPI configuration for the HRMS application.
 * It defines the metadata for the API documentation and sets up security requirements for endpoints.
 * This configuration is used to generate the Swagger UI documentation for API consumers.
 */
@Configuration
public class SwaggerConfiguration {

    /**
     * Configures the OpenAPI specification for the HRMS application.
     * This method sets the API title, description, version, license, and external documentation.
     * It also configures security schemes for JWT Bearer token authentication.
     *
     * @return OpenAPI instance with the configuration settings.
     */
    @Bean
    public OpenAPI configureOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info().title("HRMS Application")
                        .description("HRMS Application Swagger")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("This service manages comprehensive employee data within the HRMS system, including profiles, current employment status, educational background, work experience, and personal details such as family, location, and national identification. It offers endpoints for both retrieving and updating employee-related information, ensuring seamless integration and accessibility of employee data across the HRMS platform.")
                        .url("https://springboot.wiki.github.org/docs"));

    }
}

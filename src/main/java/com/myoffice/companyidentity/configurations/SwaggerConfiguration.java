package com.myoffice.companyidentity.configurations;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI configureOpenAPI() {
        OpenAPI openAPI = new OpenAPI()
                .info(new Info()
                        .title("HRMS Application")
                        .description("HRMS Application Swagger")
                        .version("v0.0.1")
                        .license(new io.swagger.v3.oas.models.info.License().name("Apache 2.0").url("http://springdoc.org"))
                )
                .externalDocs(new io.swagger.v3.oas.models.ExternalDocumentation()
                        .description("This service manages comprehensive employee data within the HRMS system, including profiles, current employment status, educational background, work experience, and personal details such as family, location, and national identification. It offers endpoints for both retrieving and updating employee-related information, ensuring seamless integration and accessibility of employee data across the HRMS platform.")
                        .url("https://springboot.wiki.github.org/docs")
                );
        openAPI.setOpenapi("3.0.1"); // Explicitly set OpenAPI version
        return openAPI;
    }
}

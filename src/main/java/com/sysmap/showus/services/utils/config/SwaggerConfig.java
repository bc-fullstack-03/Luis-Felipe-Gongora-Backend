package com.sysmap.showus.services.utils.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "ShowUs Project API",
                version = "1.0.0",
                description = "This social network project API is a project for the SysMap bootcamp",
                contact = @Contact(
                        name = "Luis Felipe Gongora Garcia",
                        email = "lfelipeggarcia@gmail.com"
                )
        )
)
@SecurityScheme(
        name = "token",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi authenticationApi(){
        String [] paths = {"/api/v1/**"};
        return GroupedOpenApi.builder()
                .group("Show-Us")
                .pathsToMatch(paths)
                .build();
    }
}

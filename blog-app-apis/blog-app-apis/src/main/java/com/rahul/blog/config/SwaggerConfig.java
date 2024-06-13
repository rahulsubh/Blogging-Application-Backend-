package com.rahul.blog.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        String scemeName = "bearerScheme";
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                .addList(scemeName)
                )
                .components(new Components()
                .addSecuritySchemes(scemeName,new SecurityScheme()
                        .name(scemeName)
                        .type(SecurityScheme.Type.HTTP)
                        .bearerFormat("JWT")
                        .scheme("bearer")
                )
                )
                .info(new Info().title("Blogging Application : Backend Course")
                .description("This project is developed by Rahul")
                        .version("1.0")
                        .contact(new Contact().name("Rahul").url("https://rahul.com")
                                .email("bppcs.11500118076@gmail.com")
                        ).license(new License().name("License of APIS"))
                ).externalDocs(new ExternalDocumentation().url("https://rahul.com").description("this is external url"));
    }

//    public static final String AUTHORIZATION_HEADER = "Authorization";
//    private ApiKey apiKey(){
//        return new ApiKey("JWT",AUTHORIZATION_HEADER,"header");
//    }
//    private List<SecurityContext> securityContexts(){
//        return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
//    }
//    private List<SecurityReference> sf(){
//        AuthorizationScope scope = new AuthorizationScope("global","accessEverything");
//        return Arrays.asList(new SecurityReference("JWT",new AuthorizationScope[] {scope}));
//    }

//    @Bean
//    public Docket api(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(getInfo())
//                .securityContexts(securityContexts())
//                .securitySchemes(Arrays.asList(apiKey()))
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }

//    private ApiInfo getInfo() {
//        return new ApiInfo(
//                "Blogging Application : Backend Course",
//                "This project is developed by Rahul",
//                "1.0",
//                "Terms of Service",
//                new Contact("Rahul","https://rahul.com","bppcs.11500118076@gmail.com"),
//                "License of APIS",
//                "API license URL",
//                Collections.emptyList());
//    }
}

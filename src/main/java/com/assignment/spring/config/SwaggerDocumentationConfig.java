package com.assignment.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger 2 configuration.
 *
 * @author Diego Fernando Junco
 * @since 2020-06-10
 */
@Configuration
public class SwaggerDocumentationConfig {

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Spring Boot Coding Dojo")
        .description("Spring Boot Coding Dojo By Diego Junco")
        .version("1.0.0")
        .contact(
            new Contact(
                "Diego Junco",
                "https://www.linkedin.com/in/diego-junco/",
                "djunco@mobiquityinc.com"))
        .build();
  }

  /** Configures Swagger 2. */
  @Bean
  public Docket customImplementation() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.assignment.spring.controller"))
        .build()
        .apiInfo(apiInfo());
  }
}

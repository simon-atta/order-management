package com;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan(basePackages = { "com.crossover.*" })
@EnableJpaRepositories(basePackages = { "com.crossover.*" })
@Import(CustomizedRestMvcConfiguration.class)
@EnableAutoConfiguration
@EntityScan(basePackages = { "com.crossover.*" })
@SpringBootApplication
@EnableSwagger2
public class SalesorderBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesorderBeApplication.class, args);
	}

	@Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("SalesOrder").apiInfo(apiInfo()).select()
                .paths(regex("/api.*")).build().securitySchemes(newArrayList(apiKeyBasicAuth()))
                .securityContexts(newArrayList(securityContext()));
    }

    private BasicAuth apiKeyBasicAuth() {
        return new BasicAuth("BasicAuth");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/.*")).build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("BasicAuth", "basic");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(new SecurityReference("BasicAuth", authorizationScopes));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("CrossOver SalesOrder API")
                .description("CrossOver SalesOrder API help for manage inventory").contact("Simon Ghobreil")
                .version("1.0").build();
    }

}

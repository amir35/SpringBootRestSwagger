package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/customer/"), regex("/customer.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SpringBoot Rest API Swagger")
				.description("These API created for Customer CRUD application")
				.termsOfServiceUrl("http://amirahmad786.blogspot.com/")
				.contact("mohdamir.ahmad1992@gmail.com").license("MohdAmirAhmad License")
				.licenseUrl("http://amirahmad786.blogspot.com/").version("1.0").build();
	}

}
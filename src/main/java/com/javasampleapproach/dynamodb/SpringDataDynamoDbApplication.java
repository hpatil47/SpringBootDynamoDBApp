package com.javasampleapproach.dynamodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@SpringBootApplication
@EnableSwagger2
public class SpringDataDynamoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDynamoDbApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Spring Boot Rest Api For Customers Data",
				"Spring Boot Rest Api For Customers Data to Store and Get it from Dynamodb.",
				"1.0",
				"Terms of service",
				new Contact("Harshal Patil", "www.example.com", "hpatil47@gmail.com"),
				"License of API", "API license URL", Collections.emptyList());
	}

}

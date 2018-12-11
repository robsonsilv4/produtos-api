package com.robson.produtos.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket produtoApi() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
            .apis(
            	RequestHandlerSelectors.
            	basePackage("com.robson.produtos")
            )
            .paths(regex("/api.*"))
            .build()
            .apiInfo(metaInfo());
	}
	
	private ApiInfo metaInfo() {
		@SuppressWarnings("rawtypes")
		ApiInfo apiInfo = new ApiInfo(
				"Produtos", "API REST com Spring Boot 2",
				"1.0", "Repassando Conhecimento",
				new Contact(
					"Robson Silva",
					"https://www.github.com/robsonsilv4",
					"robsonsilv410@gmail.com"),
                	"Apache License Version 2.0",
                	"https://www.apache.org/licesen.html",
                	new ArrayList<VendorExtension>()
				);
		return apiInfo;
	}

}

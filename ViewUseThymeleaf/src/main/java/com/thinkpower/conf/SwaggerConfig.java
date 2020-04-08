package com.thinkpower.conf;

import java.util.Collections;

import org.springframework.context.annotation.Bean;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
	            .apis(RequestHandlerSelectors.any())
	            .paths(PathSelectors.any())
	            .build()
	            .apiInfo(apiInfo());
	}
	@Bean
	private ApiInfo apiInfo() {
		return new ApiInfo(
		            "Spring Boot  Swagger 實例",
		            "desc1",
		            "API V1.0",
		            "Terms of service",
		            new Contact("名字沒想好", "https://itweknow.cn", "gancy.programmer@gmail.com"),
		                "Apache", "http://www.apache.org/", Collections.emptyList());
		}
}

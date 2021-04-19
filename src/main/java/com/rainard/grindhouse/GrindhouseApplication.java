package com.rainard.grindhouse;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class GrindhouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrindhouseApplication.class, args);
	}



	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.version("1.0")
						.title("GrindHouse")
						.description("Backend API for Coffee Shop Demo")
						.termsOfService("http://swagger.io/terms/")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}



}

package com.vuanhnguyenduc.vuanhportfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/
//https://dzone.com/articles/why-springboot
//https://stackoverflow.com/questions/11880924/how-to-add-custom-method-to-spring-data-jpa
//http://www.megangtalley.com/
@SpringBootApplication
@EnableJpaAuditing
public class VuanhPortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(VuanhPortfolioApplication.class, args);
	}
}

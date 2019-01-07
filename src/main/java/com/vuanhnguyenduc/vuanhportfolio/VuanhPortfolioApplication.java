package com.vuanhnguyenduc.vuanhportfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/
//https://dzone.com/articles/why-springboot
//https://stackoverflow.com/questions/11880924/how-to-add-custom-method-to-spring-data-jpa
//http://www.megangtalley.com/

/*
Spring Security

http://www.mkyong.com/spring-boot/spring-boot-spring-security-thymeleaf-example/
https://spring.io/guides/gs/securing-web/
https://www.baeldung.com/spring-boot-security-autoconfiguration
https://stackoverflow.com/questions/30366405/how-to-disable-spring-security-for-particular-url/30366773
https://www.baeldung.com/get-user-in-spring-security

Get users from MySQL
https://medium.com/@gustavo.ponce.ch/spring-boot-spring-mvc-spring-security-mysql-a5d8545d837d

<th:block sec:authorize="hasRole('ROLE_ADMIN')">
    This content is only shown to administrators.
</th:block>

Custom error pages
https://www.baeldung.com/spring-boot-custom-error-page
https://stackoverflow.com/questions/22948257/thymeleaf-not-displaying-spring-form-error-messages

Primary Keys
https://www.thoughts-on-java.org/jpa-generate-primary-keys/

Generic Controllers and Service
https://github.com/fsonmezay/generic-rest-api
*/
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableJpaAuditing
public class VuanhPortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(VuanhPortfolioApplication.class, args);
	}
}

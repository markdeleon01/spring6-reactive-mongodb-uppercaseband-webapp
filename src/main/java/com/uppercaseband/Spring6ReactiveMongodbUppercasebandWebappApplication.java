package com.uppercaseband;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Spring6ReactiveMongodbUppercasebandWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring6ReactiveMongodbUppercasebandWebappApplication.class, args);
	}

}

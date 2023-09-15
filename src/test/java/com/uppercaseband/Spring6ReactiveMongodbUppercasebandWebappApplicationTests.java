package com.uppercaseband;

import com.uppercaseband.repositories.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class Spring6ReactiveMongodbUppercasebandWebappApplicationTests {

	@Autowired
	ApplicationContext context;

	@Autowired
	ArticleRepository articleRepository; // inject the repository bean from the Spring context

	@Test
	void contextLoads() {
		log.debug("Spring6ReactiveMongodbUppercasebandWebappApplicationTests context loaded");
		// perform a sanity check to verify that the beans were loaded (not null)
		assertNotNull(Spring6ReactiveMongodbUppercasebandWebappApplication.class);
		assertNotNull(context);
		assertNotNull(articleRepository);
	}

}

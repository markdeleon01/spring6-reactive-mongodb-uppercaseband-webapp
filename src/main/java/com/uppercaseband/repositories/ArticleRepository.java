package com.uppercaseband.repositories;

import com.uppercaseband.domain.Article;
import com.uppercaseband.domain.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ArticleRepository extends ReactiveMongoRepository<Article, String> {

    Flux<Article> findByCategory(Category c);	//find zero or more elements of Article based on Category
}

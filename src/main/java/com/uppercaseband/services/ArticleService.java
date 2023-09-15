package com.uppercaseband.services;

import com.uppercaseband.model.ArticleDTO;
import reactor.core.publisher.Flux;

public interface ArticleService {	//the service returns reactive types (mono or flux)

    Flux<ArticleDTO> getAllArticles();

    Flux<ArticleDTO> getArticlesByCategory(String category);

}

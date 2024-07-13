package com.uppercaseband.controllers;

import com.uppercaseband.model.ArticleDTO;
import com.uppercaseband.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import reactor.core.publisher.Flux;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    //provide a constant for the base URL
    public static final String BASE_URL = "/api/v2/articles";

    private final ArticleService articleService;


    @GetMapping(ArticleController.BASE_URL)
    public Flux<ArticleDTO> getAllArticles() {

        return articleService.getAllArticles();
    }


    @GetMapping(path = ArticleController.BASE_URL+"/category/{category}")
    public Flux<ArticleDTO> getArticlesByCategory(@PathVariable Optional<String> category) {

        return articleService.getArticlesByCategory(category.get().toUpperCase())
                .switchIfEmpty(Flux.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }
}

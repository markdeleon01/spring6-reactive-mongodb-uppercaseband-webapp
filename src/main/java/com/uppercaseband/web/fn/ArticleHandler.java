package com.uppercaseband.web.fn;

import com.uppercaseband.model.ArticleDTO;
import com.uppercaseband.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ArticleHandler {

    private final ArticleService articleService;

    public Mono<ServerResponse> getAllArticles(ServerRequest request) {
        return ServerResponse
                .ok()
                .body(articleService.getAllArticles(), ArticleDTO.class);
    }

    public Mono<ServerResponse> getArticlesByCategory(ServerRequest request) {
        return ServerResponse
                .ok()
                .body(articleService.getArticlesByCategory(
                        request.pathVariable("category").toUpperCase())
                        , ArticleDTO.class);
    }
}
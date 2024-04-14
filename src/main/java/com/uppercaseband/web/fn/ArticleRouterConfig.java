package com.uppercaseband.web.fn;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class ArticleRouterConfig {

    //provide a constant for the base URL
    public static final String BASE_URL = "/api/v2/articles";
    public static final String ARTICLE_CATEGORY = BASE_URL + "/category/{category}";

    private final ArticleHandler articleHandler;

    @Bean
    public RouterFunction<ServerResponse> articleRoutes() {
        return route()
                .GET(BASE_URL, accept(APPLICATION_JSON),
                        articleHandler::getAllArticles)
                .GET(ARTICLE_CATEGORY, accept(APPLICATION_JSON),
                        articleHandler::getArticlesByCategory)
                .build();

    }
}
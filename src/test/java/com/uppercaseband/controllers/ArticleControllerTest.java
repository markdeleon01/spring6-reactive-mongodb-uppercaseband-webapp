package com.uppercaseband.controllers;

import com.uppercaseband.domain.Category;
import com.uppercaseband.model.ArticleDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@Slf4j
@SpringBootTest
@AutoConfigureWebTestClient
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ArticleControllerTest {

    @Autowired
    WebTestClient webTestClient;    // Spring Context is loaded and BootStrapData executed on application startup

    @Test
    @Order(1)
    public void testGetAllArticles() {
        log.debug("testGetAllArticles");

        webTestClient.get().uri(ArticleController.BASE_URL)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().jsonPath("$.size()").isEqualTo(3);
    }

    @Test
    @Order(20)
    public void testGetArticlesByCategory() {
        log.debug("testGetArticlesByCategory");

        webTestClient.get().uri(ArticleController.BASE_URL + "/category/"+ Category.HIGHLIGHTS)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().jsonPath("$.size()").isEqualTo(2);
    }

    @Test
    @Order(4)
    public void testGetArticlesByInvalidCategory() {
        log.debug("testGetArticlesByInvalidCategory");

        webTestClient.get().uri(ArticleController.BASE_URL + "/category/SOME_INVALID_CATEGORY")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectStatus().isNotFound();
    }

    @Test
    @Order(6)
    public void testGetArticlesByNoCategory() {
        log.debug("testGetArticlesByNoCategory");

        webTestClient.get().uri(ArticleController.BASE_URL + "/category/")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectStatus().isNotFound();
    }

    @Test
    @Order(5)
    public void testGetArticlesByEmptyCategory() {
        log.debug("testGetArticlesByEmptyCategory");

        webTestClient.get().uri(ArticleController.BASE_URL + "/category/")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectStatus().isNotFound();
    }

    @Test
    @Order(8)
    public void testGetArticlesByCategoryResponseBody() {
        log.debug("testGetArticlesByCategoryResponseBody");

        webTestClient.get().uri(ArticleController.BASE_URL + "/category/"+ Category.EVENTS)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().jsonPath("$", ArticleDTO.class);
    }
}
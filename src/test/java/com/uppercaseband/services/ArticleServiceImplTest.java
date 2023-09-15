package com.uppercaseband.services;

import com.uppercaseband.domain.Article;
import com.uppercaseband.domain.Category;
import com.uppercaseband.domain.Media;
import com.uppercaseband.domain.MediaType;
import com.uppercaseband.mappers.ArticleMapper;
import com.uppercaseband.mappers.ArticleMapperImpl;
import com.uppercaseband.mappers.MediaMapper;
import com.uppercaseband.model.ArticleDTO;
import com.uppercaseband.repositories.ArticleRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import reactor.core.publisher.Flux;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class ArticleServiceImplTest {	//unit tests the service and mappers

    ArticleService articleService;

    @MockBean
    ArticleRepository articleRepository;    // mock the repository

    @Autowired
    ArticleMapper articleMapper;    // use the mapper from the Spring context


    @BeforeAll
    public void setUp() {
        articleService = new ArticleServiceImpl(articleRepository, articleMapper);

        assertNotNull(articleMapper);
        assertNotNull(ArticleMapper.INSTANCE);
        assertNotNull(MediaMapper.INSTANCE);
    }


    @Test
    public void testGetAllArticles() {
        //behaviour-based development

        //given
        Set<Article> articlesSet = new HashSet<>();
        articlesSet.add( getTestArticle1() );
        articlesSet.add( getTestArticle2() );
        articlesSet.add( getTestArticle3() );

        //when
        when( articleRepository.findAll() ).thenReturn(Flux.fromIterable(articlesSet));

        //then
        Flux<ArticleDTO> articles = articleService.getAllArticles();
        Long count = articles.count().block();	//trigger the service call and conversions
        assertEquals(3, count);
        verify(articleRepository, times(1)).findAll();
    }


    @Test
    void getArticlesByCategory() throws Exception {
        //behaviour-based development

        //given
        given(articleRepository.findByCategory(any(Category.class))).willReturn(Flux.just(getTestArticle3()));

        //when
        Flux<ArticleDTO> articles = articleService.getArticlesByCategory(Category.EVENTS.name());

        //then
        Long count = articles.count().block();	//trigger the service call and conversions
        assertEquals(1, count);
        verify(articleRepository, times(1)).findByCategory(any(Category.class));
    }


    Article getTestArticle1() {
        Media article1Media = Media.builder()
                .type(MediaType.IMAGE)
                .path("/images/tanging_ikaw.png")
                .build();

        return Article.builder()
                .title("Tanging Ikaw")
                .description("The brand new single from UPPERCASE released under Radio Insect Records")
                .displayOrder(100)
                .category(Category.HIGHLIGHTS)
                .subContent("<a href='https://open.spotify.com/artist/6h4pjpssOa3fBNiQmSkgOB?si=lbGJiYu7R_6ouDMIs7Jv3A'>CHECK IT OUT</a>")
                .media(article1Media)
                .build();
    }

    Article getTestArticle2() {
        Media article2Media = Media.builder()
                .type(MediaType.IMAGE)
                .path("/images/tsw_album.png")
                .build();

        return Article.builder()
                .title("'Time Space Warp' Album Launch")
                .description("May 17, 2013 – Hard Rock Café Toronto")
                .displayOrder(200)
                .category(Category.HIGHLIGHTS)
                .subContent("<p><a href='https://www.facebook.com/pg/cyberpinoyradio/photos/?tab=album&album_id=657041557656169'>SEE EVENT PICS</a></p><p><a href='https://youtu.be/yNt0JV8or3k?list=PL0AgfLYM2K_sKTvDMqLY4sDr8Pi1zadB0'>WATCH EVENT VIDEO</a></p>")
                .media(article2Media)
                .build();
    }

    Article getTestArticle3() {
        Media article3Media = Media.builder()
                .type(MediaType.VIDEO)
                .path("<iframe width=\"560\" height=\"315\" src=\"//www.youtube.com/embed/ZfNUPtLtH5w\" frameborder=\"0\" allowfullscreen></iframe>")
                .build();

        return Article.builder()
                .title("'Time Space Warp' Music Video Launch")
                .description("July 12, 2013 – Prestige Bar, North York")
                .displayOrder(300)
                .category(Category.EVENTS)
                .media(article3Media)
                .build();
    }
}

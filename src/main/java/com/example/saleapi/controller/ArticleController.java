package com.example.saleapi.controller;

import com.example.saleapi.dto.ArticleDto;
import com.example.saleapi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;


@RestController
@RequestMapping("sale-api/article")
@CrossOrigin(origins = "http://localhost:4200")
public class ArticleController {
    @Resource
    ArticleService articleService;
    @PostMapping("/add")
    public Mono<ArticleDto> addArticle(@RequestBody @Validated final ArticleDto articleDto){
        return articleService.save(articleDto);
    }
    @DeleteMapping("/delete/{id}")
    public Mono<ArticleDto> deleteArticle(@PathVariable("id") final int id){
        return articleService.deleteArticle(id);
    }
    @PutMapping("/update")
    public Mono<ArticleDto> updateArticle(@RequestBody @Validated final ArticleDto articleDto){
        return articleService.updateArticle(articleDto);
    }
    @GetMapping("/{id}")
    public Mono<ArticleDto> getArticle(@PathVariable("id") final int id){
        return articleService.getArticleById(id);
    }
    @GetMapping("/name/{name}")
    public Flux<ArticleDto> getArticlesByName(@PathVariable("name")final String name){
        return articleService.getArticleByName(name);
    }
    @GetMapping("/denomination/{denomination}")
    public Flux<ArticleDto> getArticle(@PathVariable("denomination") final String denomination){
        return articleService.getArticlesByDenomination(denomination);
    }
    @GetMapping("/all")
    public Flux<ArticleDto> getAllArticles(){
        return articleService.getAllArticles();
    }

    @GetMapping("/client/{clientName}")
    public Mono<ArticleDto> getArticlesByClientName(@PathVariable("clientName")final String clientName){
        return articleService.getArticleByClientName(clientName);
    }
}

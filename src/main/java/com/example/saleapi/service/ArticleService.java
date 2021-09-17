package com.example.saleapi.service;

import com.example.saleapi.dto.ArticleDto;
import com.example.saleapi.exception.EntityException;
import com.example.saleapi.mapper.ArticleMapper;
import com.example.saleapi.repository.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;


@Service
public class ArticleService {
    @Resource
    ArticleRepo articleRepo;
    @Resource
    ArticleMapper articleMapper;
    public Mono<ArticleDto> save(final ArticleDto articleDto){
        return Mono.justOrEmpty(articleDto)
                .switchIfEmpty(Mono.error(EntityException.toSupplier("input: is null")))
                .map(articleMapper::toBo)
                .map(articleRepo::save)
                .onErrorResume(DataAccessException.class, throwable -> Mono.error(EntityException.toSupplier("Failed to create entity", throwable)))
                .map(articleMapper::toDto);

    }
    public Mono<ArticleDto> getArticleById(final int id) {
        return Mono.justOrEmpty(this.articleRepo.findById(id))
                .switchIfEmpty(Mono.error(EntityException.toSupplier("id: " + id + " not found")))
                .map(articleMapper::toDto);
    }
    public Flux<ArticleDto> getArticlesByDenomination(final String denominantion) {
        return Flux.fromIterable(this.articleRepo.findByDenomination(denominantion))
                .switchIfEmpty(Mono.error(EntityException.toSupplier("not found")))
                .map(articleMapper::toDto);
    }
    public Flux<ArticleDto> getAllArticles(){
        return Flux.fromIterable(articleRepo.findAll())
                .switchIfEmpty(Mono.error(EntityException.toSupplier("there is no articles")))
                .map(articleMapper::toDto);
    }
    public Mono<ArticleDto> deleteArticle(final int id){
        return Mono.justOrEmpty(this.articleRepo.findById(id))
                .doOnNext(articleRepo::delete)
                .switchIfEmpty(Mono.error(EntityException.toSupplier("object not found")))
                .map(articleMapper::toDto);

    }
    public Mono<ArticleDto> updateArticle(final ArticleDto articleDto){
        return Mono.justOrEmpty(articleDto)
                .map(articleMapper::toBo)
                .map(articleRepo::save)
                .map(articleMapper::toDto);
    }

    public Flux<ArticleDto> getArticleByName(String name) {
        return Flux.fromIterable(articleRepo.findByDenomination(name))
                .switchIfEmpty(Mono.error(EntityException.toSupplier("article not found")))
                .map(articleMapper::toDto);

    }
    public Mono<ArticleDto> getArticleByClientName(final String clientName) {
        return Mono.justOrEmpty(this.articleRepo.findByClientName(clientName))
                .switchIfEmpty(Mono.error(EntityException.toSupplier("client: " + clientName + " not found")))
                .map(articleMapper::toDto);
    }
}

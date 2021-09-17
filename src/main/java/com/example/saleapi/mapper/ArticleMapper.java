package com.example.saleapi.mapper;

import com.example.saleapi.dto.ArticleDto;
import com.example.saleapi.model.Article;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ArticleMapper extends GenericMapper<Article, ArticleDto>{
}

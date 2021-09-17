package com.example.saleapi.mapper;

import com.example.saleapi.dto.ArticleDto;
import com.example.saleapi.dto.TvaDto;
import com.example.saleapi.model.Article;
import com.example.saleapi.model.Tva;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
@Component
@Mapper(componentModel = "spring")
public interface TvaMapper extends GenericMapper<Tva, TvaDto>{
}


package com.example.saleapi.mapper;

import com.example.saleapi.dto.ArticleDto;
import com.example.saleapi.dto.BillDto;
import com.example.saleapi.model.Article;
import com.example.saleapi.model.Bill;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BillMapper extends GenericMapper<Bill, BillDto>{
}

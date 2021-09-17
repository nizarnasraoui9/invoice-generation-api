package com.example.saleapi.dto;

import com.example.saleapi.model.Bill;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {
    int id;
    String denomination;
    String type;
    String unit;
    Integer unitPrice;
    int tva;
    String reference;
    String comment;

    @JsonIgnore
    List<Bill> bills;
    String clientName;


}
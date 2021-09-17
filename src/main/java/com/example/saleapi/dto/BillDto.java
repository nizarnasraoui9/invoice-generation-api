package com.example.saleapi.dto;

import com.example.saleapi.model.Article;
import com.example.saleapi.model.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDto {
    long id;
    List<Article> articles;
    List<Client> clients;
    double price;
    double priceWithTva;
    String emissionDate;
    String dueDate;
    String reglementCondition;

}

package com.example.saleapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_article")
    int id;
    String denomination;
    String type;
    String unit;
    Integer unitPrice;
    int tva;
    String reference;
    String comment;
    String emissionDate;
    String dueDate;
    String reglementCondition;
    String userName;
    @ManyToMany
    @JoinTable( name = "article_bills",
            joinColumns = @JoinColumn( name = "id_article" ),
            inverseJoinColumns = @JoinColumn( name = "id_bill" ) )
    List<Bill> bills;
    String clientName;


}

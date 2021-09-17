package com.example.saleapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
            @Column(name="id_bill")
    long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "article_bills",
            joinColumns = @JoinColumn( name = "id_bill" ),
            inverseJoinColumns = @JoinColumn( name = "id_article" ) )
    List<Article> articles;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "client_bills",
            joinColumns = @JoinColumn( name = "id_bill" ),
            inverseJoinColumns = @JoinColumn( name = "id_client" ) )
    List<Client> clients;
    double price;
    double priceWithTva;
    String emissionDate;
    String dueDate;
    String reglementCondition;

    public Bill(List<Article> articles, List<Client> clients, double price, double priceWithTva) {
        this.articles = articles;
        this.clients = clients;
        this.price = price;
        this.priceWithTva = priceWithTva;
    }
}

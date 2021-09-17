package com.example.saleapi.service;

import com.example.saleapi.dto.BillDto;
import com.example.saleapi.mapper.ArticleMapper;
import com.example.saleapi.mapper.BillMapper;
import com.example.saleapi.model.*;
import com.example.saleapi.repository.ArticleRepo;
import com.example.saleapi.repository.BillRepo;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import io.swagger.v3.core.util.Json;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.*;

@Service
public class BillService {
    @Resource
    ArticleRepo articleRepo;
    @Resource
    BillRepo billRepo;
    @Resource
    BillMapper billMapper;
    @Resource
    WebClient webClient;
    @Resource
    ArticleMapper articleMapper;

    public Mono<BillDto> addBill(ArrayList<Cra> cras) {
        ArrayList<Integer>prices=new ArrayList<>();
        ArrayList<Client> clients=new ArrayList<>();
        ArrayList<Article> articles=new ArrayList<>();
        double sum=0,price=0,priceWithTva=0;
        for(Cra cra: cras){
            sum=wokrDaysSum(cra);
            System.out.println(sum);
            price+=calculatePrice(cra,sum).get("price");
            priceWithTva+=calculatePrice(cra,sum).get("priceWithTva");
            clients.add(cra.getClient());
            for(Article article:cra.getArticles()){
                articles.add(article);
            }


        }
        Bill bill=new Bill(articles,clients,price,priceWithTva);
        return Mono.justOrEmpty(billRepo.save(bill)).map(billMapper::toDto);
    }

    private static HashMap<String,Double> calculatePrice(Cra cra, double numberOfWorkDays) {
        double price=0;
        double priceWithTva=0;
        double sumOfPrices=0;
        double sumOfpricesWithTva=0;
        for(Article article: cra.getArticles()){
            sumOfPrices+=article.getUnitPrice();
            sumOfpricesWithTva+=article.getUnitPrice()+(article.getUnitPrice()* article.getTva())/100;


        }
        price=sumOfPrices*numberOfWorkDays;
        priceWithTva+=sumOfpricesWithTva*numberOfWorkDays;
        HashMap<String,Double> map=new HashMap<>();
        map.put("price",price);
        map.put("priceWithTva",priceWithTva);




        return map;
    }

    public static double wokrDaysSum(Cra cra){
        String workedTime="";
        double sum=0;
        for(WorkDay workDay:cra.getWorkDays()) {
            workedTime = workDay.getWorkedTime();
            switch (workedTime) {
                case "full":
                    sum++;
                    break;
                case "half":
                    sum =sum + 0.5;
            }
        }

        return sum;
    }





    public Mono<BillDto> getBill(int id) {
        return Mono.justOrEmpty(billRepo.findById(id))
                .map(billMapper::toDto);
    }










































    /*
    @Resource
    ArticleRepo articleRepo;
    @Resource
    BillRepo billRepo;
    @Resource
    BillMapper billMapper;
    @Resource
    WebClient webClient;
    @Resource
    ArticleMapper articleMapper;


    public Mono<String> authenticate()
    {
        Gson gson = new Gson();
        JSONObject request = new JSONObject();
        request.put("username", "admin");
        request.put("password", "password");
        return this.webClient.post()
                .uri("http://localhost:8080/authenticate")
                .body(Mono.just(request), JSONObject.class)
                .retrieve()
                .bodyToMono(String.class);
    }



    public Mono<String> getCra(int num,String token){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        return  this.webClient.get()
                .uri("http://localhost:8080/cras/"+num)
                .header("Authorization", token)
                .retrieve()
                .bodyToMono(String.class);
    }

    public int countWorkDays(String cra){
        int sum=0;
        Gson gson = new Gson();
        Map mapCra = gson.fromJson(cra.toString(), Map.class);
        ArrayList<Object> workDaysList=(ArrayList<Object>) mapCra.get("workDays");

        for(int i=0;i<31;i++){
            LinkedTreeMap day=(LinkedTreeMap)workDaysList.get(i);
            String workedTime=(String)day.get("workedTime");
            switch (workedTime){
                case "full":
                    sum++;break;
                case "half":
                    sum+=0.5;
            }
        }
        return sum;
    }
    public Mono<BillDto> saveBill(List<Article> articles, int craId, int contractedId, int clientId, int numberOfWorkDays ){
        /*int price=0;
        Optional<Article> article=this.articleRepo.findById(articleId);
        if(article.isPresent()){
            price=article.get().getUnitPrice()*numberOfWorkDays;
            price+=(price*article.get().getTva())/100;
        }*//*
        int priceSum=0;
        int priceSumWithTva=0;
        for(int i=0;i<articles.size();i++){
            priceSum+=articles.get(i).getUnitPrice();
            priceSumWithTva+=priceSum+(priceSum/100)*articles.get(i).getTva();
        }
        int price=numberOfWorkDays*priceSumWithTva;
        return Mono.justOrEmpty(billRepo.save(new Bill(craId,contractedId,clientId,articles,price)))
                .map(billMapper::toDto);


    }
    public Mono<BillDto>addBill(List<Article> articles, int craId, int clientId, int contractedId){
        return this.authenticate().map((token)->{
            Gson gson = new Gson();
            Map map = gson.fromJson(token.toString(), Map.class);
            return "Bearer "+(String) map.get("jwttoken");
        }).flatMap((token)->{
            return this.getCra(craId,token);
        }).map((cra)->{
            return this.countWorkDays(cra);
        }).flatMap((numberOfWorkDays)->{
            return this.saveBill(articles,craId,contractedId,clientId,numberOfWorkDays );
        });
    }
    public Mono<BillDto> getBill(int id){
        return Mono.justOrEmpty(billRepo.findById(id))
        .map(billMapper::toDto);
    }*/

}

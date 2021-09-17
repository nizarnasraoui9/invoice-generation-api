package com.example.saleapi.controller;

import com.example.saleapi.dto.BillDto;
import com.example.saleapi.mapper.BillMapper;
import com.example.saleapi.model.Article;
import com.example.saleapi.model.BillRequest;
import com.example.saleapi.model.Cra;
import com.example.saleapi.service.BillService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import io.swagger.v3.core.util.Json;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sale-api/bill")
@CrossOrigin(origins = "http://localhost:4200")
public class BillController {
    @Resource
    BillService billService;
    @Resource
    BillMapper billMapper;

    @GetMapping("get/id/{id}")
    public Mono<BillDto> getBill(@PathVariable int id){
        return this.billService.getBill(id);
    }

    @PostMapping("add/{releaseDate}/{dueDate}")
    public Mono<BillDto> addBill(@RequestBody ArrayList<Cra> cras){
        return billService.addBill(cras);
    }

    /*@PostMapping("add/{craId}/{clientId}/{contractedId}")
        public Mono<BillDto> addBill(List<Article> articles, @PathVariable int articleId, @PathVariable int craId, @PathVariable int clientId, @PathVariable int contractedId){
        return this.billService.addBill( articles, craId, clientId, contractedId);


    }*/
    @PostMapping("test")
        public Article test(@RequestBody  ObjectNode objectNode){
        String article=objectNode.get("articles").asText();
        Gson gson=new Gson();
        Article ar=gson.fromJson(article,Article.class);
        System.out.println(ar);

        return ar;
    }




}

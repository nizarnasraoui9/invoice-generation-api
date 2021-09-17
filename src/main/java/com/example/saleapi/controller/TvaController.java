package com.example.saleapi.controller;

import com.example.saleapi.dto.TvaDto;
import com.example.saleapi.model.Tva;
import com.example.saleapi.repository.TvaRepo;
import com.example.saleapi.service.ArticleService;
import com.example.saleapi.service.TvaService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@RestController
@RequestMapping("sale-api/tva")
@CrossOrigin(origins = "http://localhost:4200")
public class TvaController {
    @Resource
    TvaService tvaService;
    @GetMapping("get/all")
    public Flux<TvaDto> getAllTva(){
        return tvaService.getAllTva();
    }
    @PostMapping("add")
    Mono<TvaDto> addTva(@RequestBody TvaDto value){
        return tvaService.add(value.getValue());
    }
}

package com.example.saleapi.service;

import com.example.saleapi.dto.TvaDto;
import com.example.saleapi.mapper.TvaMapper;
import com.example.saleapi.model.Tva;
import com.example.saleapi.repository.TvaRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Service
public class TvaService {
    @Resource
    TvaMapper tvaMapper;
    @Resource
    TvaRepo tvaRepo;

    public Flux<TvaDto> getAllTva(){
        return Flux.fromIterable(tvaRepo.findAll())
                .map(tvaMapper::toDto);
    }
    public Mono<TvaDto> add(Integer value){
        return Mono.justOrEmpty(tvaRepo.save(new Tva(value)))
                .map(tvaMapper::toDto);
    }

}

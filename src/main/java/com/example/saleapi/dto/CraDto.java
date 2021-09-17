package com.example.saleapi.dto;

import com.example.saleapi.model.Article;
import com.example.saleapi.model.Client;
import com.example.saleapi.model.Contracted;
import com.example.saleapi.model.WorkDay;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CraDto {
    private long id;
    private String name;
    private String type;
    private Integer year;
    private Integer month;
    private String note;
    private String createdAt;
    private String updatedAt;
    private String local;
    private List<WorkDay> workDays;
    private Contracted contracted;
    private Client client;
    private Article[] articles;
}

package com.example.saleapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cra {
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
    private List<Article> articles=new ArrayList<Article>();
}

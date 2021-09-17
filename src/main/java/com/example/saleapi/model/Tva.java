package com.example.saleapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tva {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    Integer value;

    public Tva(Integer value) {
        this.value=value;
    }
}

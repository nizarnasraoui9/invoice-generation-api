package com.example.saleapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillRequest {
    Cra[] cras;
    Article[] articles;
    String token;

}

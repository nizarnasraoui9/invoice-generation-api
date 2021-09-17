package com.example.saleapi.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_client")
    private long id;
    private String name;
    private String siret;
    private String uniqueIdentifier;
    private String country;
    private String streetNumber;
    private String repetition;
    private String streetType;
    private String streetName;
    private String postalCode;
    private String city;
    private String contact;

    @ManyToMany
    @JoinTable( name = "client_bills",
            joinColumns = @JoinColumn( name = "id_client" ),
            inverseJoinColumns = @JoinColumn( name = "id_bill" ) )
    List<Bill> bills;

    @Transient
    List<Cra> craList=new ArrayList<>();



}

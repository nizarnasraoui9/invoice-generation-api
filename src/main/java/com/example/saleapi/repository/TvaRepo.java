package com.example.saleapi.repository;

import com.example.saleapi.model.Tva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TvaRepo extends JpaRepository<Tva,Integer> {
}


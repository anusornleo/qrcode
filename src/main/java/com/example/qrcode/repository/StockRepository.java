package com.example.qrcode.repository;

import com.example.qrcode.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    List<Stock> findByProduct_id(int id);
}

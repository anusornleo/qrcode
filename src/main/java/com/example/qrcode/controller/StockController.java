package com.example.qrcode.controller;

import com.example.qrcode.models.Stock;
import com.example.qrcode.repository.StockRepository;
import com.example.qrcode.services.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stock")
public class StockController {
    final StockRepository stockRepository;
    final StockService stockService;


    public StockController(StockRepository stockRepository, StockService stockService) {
        this.stockRepository = stockRepository;
        this.stockService = stockService;
    }

    // get all of stock
    @RequestMapping(method = RequestMethod.GET)
    public List<Stock> getStocks() {
        return stockService.getAllStock();
    }

    // get by product id
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public List<Stock> getByIdProduct(@PathVariable int id) {
        return stockRepository.findByProduct_id(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/byLocation")
    public List<Map<String, Object>> getByLocation(@RequestBody Map<String, Object> payload, @PathVariable int id) {
        double lat = (double) payload.values().toArray()[0];
        double lon = (double) payload.values().toArray()[1];
        return stockService.calculateLocation(lat,lon,id);
    }
}

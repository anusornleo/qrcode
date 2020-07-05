package com.example.qrcode.services;

import com.example.qrcode.models.Stock;
import com.example.qrcode.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

@Service
public class StockService {
    final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    public List<Map<String, Object>> calculateLocation(double lat, double lon, int id) {
        List<Map<String, Object>> listCal = new ArrayList<Map<String, Object>>();
        List<Stock> stocks = stockRepository.findByProduct_id(id);
        stocks.forEach((e) -> {
            Map<String, Object> map = new HashMap<String, Object>();

            // define value
            double lonMe = Math.toRadians(lon);
            double latMe = Math.toRadians(lat);
            double latLocation = Math.toRadians(e.getLocation().getLat());
            double lonLocation = Math.toRadians(e.getLocation().getLon());

            double dlon = lonLocation - lonMe;
            double dlat = latLocation - latMe;

            double a = Math.pow(Math.sin(dlat / 2), 2)
                    + Math.cos(latMe) * Math.cos(latLocation)
                    * Math.pow(Math.sin(dlon / 2), 2);

            double c = 2 * Math.asin(Math.sqrt(a));
            double r = 6371;

            map.put("stock", e);
            map.put("distance", c * r);
            DecimalFormat df = new DecimalFormat("00000.00");
            map.put("distanceCompare", df.format(c * r));
            listCal.add(map);
        });
        Collections.sort(listCal, mapComparator);
        return listCal;
    }

    public Comparator<Map<String, Object>> mapComparator = new Comparator<Map<String, Object>>() {
        public int compare(Map<String, Object> m1, Map<String, Object> m2) {
            return m1.get("distanceCompare").toString().compareTo(m2.get("distanceCompare").toString());
        }
    };

}

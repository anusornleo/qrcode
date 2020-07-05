package com.example.qrcode.services;

import com.example.qrcode.models.Location;
import com.example.qrcode.models.Product;
import com.example.qrcode.repository.LocationRepository;
import com.example.qrcode.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    final
    LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocation() {
        return (List<Location>) locationRepository.findAll();
    }
}

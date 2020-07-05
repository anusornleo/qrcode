package com.example.qrcode.controller;

import com.example.qrcode.models.Location;
import com.example.qrcode.models.Product;
import com.example.qrcode.services.LocationService;
import com.example.qrcode.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location")
@Controller
public class LocationController {

    final
    LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Location> getLocation() {
        return locationService.getAllLocation();
    }
}


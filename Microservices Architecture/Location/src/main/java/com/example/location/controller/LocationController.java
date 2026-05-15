package com.example.location.controller;

import com.example.location.model.Location;
import com.example.location.model.Weather;
import com.example.location.repository.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public Iterable<Location> getAll() {
        return repository.findAll();
    }

    @GetMapping("/weather")
    public Weather getWeather(
            @RequestParam String name) {

        Optional<Location> optional =
                repository.findByName(name);

        if(optional.isEmpty()) {
            return null;
        }

        Location location = optional.get();

        String request = String.format(
                "http://WEATHER-INFO-SERVICE/weather?lat=%s&lon=%s",
                location.getLatitude(),
                location.getLongitude()
        );

        return restTemplate.getForObject(
                request,
                Weather.class
        );
    }

    @PostMapping
    public Location save(
            @RequestBody Location location) {

        return repository.save(location);
    }
}
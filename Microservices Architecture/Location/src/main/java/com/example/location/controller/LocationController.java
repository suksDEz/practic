package com.example.location.controller;

import com.example.location.model.Location;
import com.example.location.model.Weather;
import com.example.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${url.weather}")
    private String weatherUrl;

    @GetMapping
    public Iterable<Location> getAll() {
        return repository.findAll();
    }

    @GetMapping(params = "name")
    public Optional<Location> getByName(
            @RequestParam String name) {

        return repository.findByName(name);
    }

    @PostMapping
    public Location save(
            @RequestBody Location location) {

        return repository.save(location);
    }

    @PutMapping
    public Location update(
            @RequestParam String name,
            @RequestBody Location newLocation) {

        Optional<Location> optional =
                repository.findByName(name);

        if (optional.isPresent()) {

            Location location = optional.get();

            location.setLatitude(newLocation.getLatitude());
            location.setLongitude(newLocation.getLongitude());
            location.setName(newLocation.getName());

            return repository.save(location);
        }

        return null;
    }

    @DeleteMapping
    public void delete(
            @RequestParam String name) {

        repository.deleteByName(name);
    }

    @GetMapping("/weather")
    public Weather getWeather(
            @RequestParam String name) {

        Location location =
                repository.findByName(name).get();

        String request = String.format(
                "%s?lat=%s&lon=%s",
                weatherUrl,
                location.getLatitude(),
                location.getLongitude()
        );

        return restTemplate.getForObject(
                request,
                Weather.class
        );
    }
}
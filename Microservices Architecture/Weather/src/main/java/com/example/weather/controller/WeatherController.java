package com.example.weather.controller;

import com.example.weather.model.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WeatherController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${appid}")
    private String appId;

    @Value("${url.weather}")
    private String urlWeather;

    private final Map<String, Root> cache = new HashMap<>();
    private final Map<String, Long> cacheTime = new HashMap<>();

    @GetMapping("/weather")
    public Root getWeather(@RequestParam String lat,
                           @RequestParam String lon) {

        String key = lat + "_" + lon;

        long currentTime = System.currentTimeMillis();

        if (cache.containsKey(key)
                && currentTime - cacheTime.get(key) < 60000) {

            return cache.get(key);
        }

        String request = String.format(
                "%s?lat=%s&lon=%s&units=metric&appid=%s",
                urlWeather,
                lat,
                lon,
                appId
        );

        Root response =
                restTemplate.getForObject(request, Root.class);

        cache.put(key, response);
        cacheTime.put(key, currentTime);

        return response;
    }
}
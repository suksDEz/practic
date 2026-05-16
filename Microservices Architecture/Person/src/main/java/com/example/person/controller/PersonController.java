package com.example.person.controller;

import com.example.person.model.User;
import com.example.person.model.Weather;
import com.example.person.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${location.url}")
    private String locationUrl;

    @GetMapping
    public Iterable<User> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getById(
            @PathVariable int id) {

        return repository.findById(id);
    }

    @PostMapping
    public User save(
            @RequestBody User user) {

        return repository.save(user);
    }

    @PutMapping("/{id}")
    public User update(
            @PathVariable int id,
            @RequestBody User newUser) {

        Optional<User> optional =
                repository.findById(id);

        if(optional.isPresent()) {

            User user = optional.get();

            user.setFirstname(newUser.getFirstname());
            user.setSurname(newUser.getSurname());
            user.setLastname(newUser.getLastname());
            user.setBirthday(newUser.getBirthday());
            user.setLocation(newUser.getLocation());

            return repository.save(user);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable int id) {

        repository.deleteById(id);
    }

    @GetMapping("/{id}/weather")
    public ResponseEntity<Weather> getWeather(
            @PathVariable int id) {

        if(repository.existsById(id)) {

            String location =
                    repository.findById(id)
                            .get()
                            .getLocation();

            String url = String.format(
                    "http://%s/location/weather?name=%s",
                    locationUrl,
                    location
            );

            Weather weather =
                    restTemplate.getForObject(
                            url,
                            Weather.class
                    );

            return new ResponseEntity<>(
                    weather,
                    HttpStatus.OK
            );
        }

        return ResponseEntity.notFound().build();
    }
}
package org.example.task4_16.controller;


import org.example.task4_16.dto.Person;
import org.example.task4_16.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController
{
    private final PersonRepository repository;

    public PersonController(PersonRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping
    public List<Person> getAll()
    {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getById(@PathVariable int id)
    {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person)
    {
        repository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable int id,
                                         @RequestBody Person person)
    {
        if (repository.findById(id).isPresent())
        {
            repository.update(id, person);
            return ResponseEntity.ok(person);
        }

        repository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        repository.delete(id);
    }
}
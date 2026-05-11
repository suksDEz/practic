package org.example.task4_16.controller;

import org.example.task4_16.dto.Message;
import org.example.task4_16.repository.MessageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController
{
    private final MessageRepository repository;

    public MessageController(MessageRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping
    public List<Message> getAll()
    {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable int id)
    {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Message> create(@RequestBody Message message)
    {
        repository.save(message);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> update(@PathVariable int id,
                                          @RequestBody Message message)
    {
        if (repository.findById(id).isPresent())
        {
            repository.update(id, message);
            return ResponseEntity.ok(message);
        }

        repository.save(message);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        repository.delete(id);
    }
}
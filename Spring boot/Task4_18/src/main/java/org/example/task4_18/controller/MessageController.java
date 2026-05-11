package org.example.task4_18.controller;

import org.example.task4_18.dto.Message;
import org.example.task4_18.repository.MessageRepository;
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
    public void create(@RequestBody Message message)
    {
        repository.save(message);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        repository.delete(id);
    }
}
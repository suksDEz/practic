package org.example.task4_18.controller;

import org.example.task4_18.dto.Person;
import org.example.task4_18.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController
{
    private final PersonService service;

    public PersonController(PersonService service)
    {
        this.service = service;
    }

    @GetMapping
    public List<Person> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getById(@PathVariable int id)
    {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person)
    {
        return service.create(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        service.delete(id);
    }


    @GetMapping("/{p_id}/message")
    public ResponseEntity<?> getMessages(@PathVariable int p_id)
    {
        return service.getMessages(p_id);
    }

    @GetMapping("/{p_id}/message/{m_id}")
    public ResponseEntity<?> getMessage(@PathVariable int p_id,
                                        @PathVariable int m_id)
    {
        return service.getMessageById(p_id, m_id);
    }

    @PostMapping("/{p_id}/message")
    public ResponseEntity<?> addMessage(@PathVariable int p_id,
                                        @RequestBody org.example.task4_18.dto.Message message)
    {
        return service.addMessage(p_id, message);
    }

    @DeleteMapping("/{p_id}/message/{m_id}")
    public ResponseEntity<?> deleteMessage(@PathVariable int p_id,
                                           @PathVariable int m_id)
    {
        return service.deleteMessage(p_id, m_id);
    }
}
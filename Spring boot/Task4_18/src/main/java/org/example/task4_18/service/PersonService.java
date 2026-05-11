package org.example.task4_18.service;

import org.example.task4_18.dto.Message;
import org.example.task4_18.dto.Person;
import org.example.task4_18.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonService
{
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository)
    {
        this.personRepository = personRepository;
    }

    public List<Person> getAll()
    {
        return personRepository.findAll();
    }

    public ResponseEntity<Person> getById(int id)
    {
        return personRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Person> create(Person person)
    {
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    public void delete(int id)
    {
        personRepository.delete(id);
    }

    public ResponseEntity<?> addMessage(int personId, Message message)
    {
        var personOpt = personRepository.findById(personId);

        if (personOpt.isEmpty())
        {
            return ResponseEntity.badRequest().body("User not found");
        }

        Person person = personOpt.get();

        message.setTime(LocalDateTime.now());
        person.getMessages().add(message);

        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> getMessages(int personId)
    {
        return personRepository.findById(personId)
                .map(p -> ResponseEntity.ok((Object) p.getMessages()))
                .orElse(ResponseEntity.badRequest().body("User not found"));
    }

    public ResponseEntity<Object> getMessageById(int personId, int messageId)
    {
        return personRepository.findById(personId)
                .<ResponseEntity<Object>>map(p ->
                        p.getMessages().stream()
                                .filter(m -> m.getId() == messageId)
                                .findFirst()
                                .<ResponseEntity<Object>>map(ResponseEntity::ok)
                                .orElse(ResponseEntity.notFound().build())
                )
                .orElse(ResponseEntity.badRequest().body((Object) "User not found"));
    }

    public ResponseEntity<?> deleteMessage(int personId, int messageId)
    {
        return personRepository.findById(personId)
                .map(p -> {
                    p.getMessages().removeIf(m -> m.getId() == messageId);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.badRequest().body("User not found"));
    }
}
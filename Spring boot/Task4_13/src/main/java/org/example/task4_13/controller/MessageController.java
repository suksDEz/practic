package org.example.task4_13.controller;

import org.example.task4_13.dto.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/message")
public class MessageController
{
    private final List<Message> messages = new ArrayList<>();

    public MessageController()
    {
        messages.add(new Message(
                1,
                "Hello",
                "Test message",
                LocalDateTime.now()
        ));

        messages.add(new Message(
                2,
                "News",
                "Spring Boot works",
                LocalDateTime.now()
        ));
    }

    @GetMapping
    public List<Message> getMessages()
    {
        return messages;
    }

    @GetMapping("/{id}")
    public Optional<Message> findMessageById(@PathVariable int id)
    {
        return messages.stream()
                .filter(message -> message.getId() == id)
                .findFirst();
    }

    @PostMapping
    public ResponseEntity<Message> addMessage(@RequestBody Message message)
    {
        messages.add(message);

        return new ResponseEntity<>(
                message,
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> updateMessage(
            @PathVariable int id,
            @RequestBody Message message)
    {
        int index = -1;

        for (Message m : messages)
        {
            if (m.getId() == id)
            {
                index = messages.indexOf(m);
                messages.set(index, message);
            }
        }

        return index == -1
                ? new ResponseEntity<>(addMessage(message).getBody(), HttpStatus.CREATED)
                : new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable int id)
    {
        messages.removeIf(message -> message.getId() == id);
    }
}
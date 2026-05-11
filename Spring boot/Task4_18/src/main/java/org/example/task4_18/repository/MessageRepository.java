package org.example.task4_18.repository;

import org.example.task4_18.dto.Message;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository
{
    private final List<Message> messages = new ArrayList<>(List.of(
            new Message(1, "Hello", "Text 1", LocalDateTime.now()),
            new Message(2, "News", "Text 2", LocalDateTime.now())
    ));

    public List<Message> findAll()
    {
        return messages;
    }

    public Optional<Message> findById(int id)
    {
        return messages.stream()
                .filter(m -> m.getId() == id)
                .findFirst();
    }

    public void save(Message message)
    {
        messages.add(message);
    }

    public void delete(int id)
    {
        messages.removeIf(m -> m.getId() == id);
    }
}
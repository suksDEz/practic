package org.example.task4_16.repository;

import org.example.task4_16.dto.Person;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository
{
    private final List<Person> persons = new ArrayList<>(List.of(
            new Person(1, "Ivan", "Ivanovich", "Ivanov", LocalDate.of(1999, 2,3)),
            new Person(2, "Петр", "Петрович", "Петров", LocalDate.of(2002, 2,2)),
            new Person(3, "Евгений", "Васильевич", "Васин", LocalDate.of(2005, 4,8)),
            new Person(4, "Максим", "Яковлевич", "Окопский", LocalDate.of(1978, 6,5))
    ));

    public List<Person> findAll()
    {
        return persons;
    }

    public Optional<Person> findById(int id)
    {
        return persons.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    public void save(Person person)
    {
        persons.add(person);
    }

    public void update(int id, Person updated)
    {
        findById(id).ifPresent(person -> {
            person.setFirstname(updated.getFirstname());
            person.setSurname(updated.getSurname());
            person.setLastname(updated.getLastname());
            person.setBirthday(updated.getBirthday());

            // ВАЖНО: сохраняем тот же id
            person.setId(id);
        });
    }

    public void delete(int id)
    {
        persons.removeIf(p -> p.getId() == id);
    }
}
package org.example.task4_18.repository;

import org.example.task4_18.dto.Person;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository
{
    private final List<Person> persons = new ArrayList<>(List.of(
            new Person(1, "Ivan", "Ivanovich", "Ivanov", "2000-01-01"),
            new Person(2, "Петр", "Петрович", "Петров", "2000-01-01"),
            new Person(3, "Евгений", "Васильевич", "Васин", "2000-01-01"),
            new Person(4, "Максим", "Яковлевич", "Окопский", "2000-01-01")
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

    public void delete(int id)
    {
        persons.removeIf(p -> p.getId() == id);
    }
}
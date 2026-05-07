package org.example.User;

public class User
{
    private String name;
    private Integer age;


    public User(String name, Integer age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        if (name == null || name.trim().isEmpty())
        {
            throw new IllegalArgumentException("Имя не может быть пустым или null");
        }

        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        if (age <= 0)
        {
            throw new IllegalArgumentException("Возраст не может быть отрицательным или равным нулю");
        }

        this.age = age;
    }

    public String toString()
    {
        return name + ", возраст " + age + " лет";
    }
}

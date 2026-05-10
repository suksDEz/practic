package org.example.task4_11;

public enum OperationType
{
    ADD("Сложение"),
    SUBTRACT("Вычитание"),
    MULTIPLY("Умножение"),
    DIVIDE("Деление");

    private final String name;

    OperationType(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}

package org.example;

public class Calculator
{
    private Operation operation;

    public Calculator(Operation operation)
    {
        this.operation = operation;
    }

    public void cal(double a, double b)
    {
        double result = operation.getResult(a, b);
        System.out.printf("Результат операции (%s) числа %.1f и числа %.1f = %s%n",
                            operation.getOperation(),
                            a,
                            b,
                            result
        );

    }
}

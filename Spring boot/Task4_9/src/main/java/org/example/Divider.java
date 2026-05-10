package org.example;

public class Divider implements Operation
{

    @Override
    public double getResult(double a, double b)
    {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль невозможно!");
        }
        return a / b;
    }

    @Override
    public String getOperation() {
        return OperationType.DIVIDE.getName();
    }
}

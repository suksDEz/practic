package org.example;

public class Subtractor implements Operation
{
    @Override
    public double getResult(double a, double b)
    {
        return a - b;
    }

    @Override
    public String getOperation() {
        return OperationType.SUBTRACT.getName();
    }
}

package org.example;
import java.util.stream.LongStream;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        System.out.println(getArithmeticProgressionSum(10_000_000, 1_000_000_000));
    }

    public static long getArithmeticProgressionSum(int a, int b)
    {
        return LongStream.range(a, b).sum();
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.task2_19;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class Task2_19 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите 3 числа:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        
        boolean hasMultipleOf5 = false;
        if (a % 5 == 0) 
        {
            System.out.print("a=" + a);
            hasMultipleOf5 = true;
        }
        if (b % 5 == 0) 
        {
            if (hasMultipleOf5) 
                System.out.print(", ");
            
            System.out.print("b=" + b);
            hasMultipleOf5 = true;
        }
        if (c % 5 == 0) 
        {
            if (hasMultipleOf5) 
                System.out.print(", ");
            
            System.out.print("c=" + c);
            hasMultipleOf5 = true;
        }
        
        if (!hasMultipleOf5) 
        {
            System.out.print("нет значений, кратных 5");
        }
        System.out.println();
        
        
        System.out.println("Результат целочисленного деления a на b: " + (a / b));
        
        double divisionResult = (double) a / b;
        System.out.println("Результат деления a на b: " + divisionResult);
        
        int ceilResult = (int) Math.ceil(divisionResult);
        System.out.println("Результат деления a на b с округлением в большую сторону: " + ceilResult);
        
        int floorResult = (int) Math.floor(divisionResult);
        System.out.println("Результат деления a на b с округлением в меньшую сторону: " + floorResult);
        
        int roundResult = (int) Math.round(divisionResult);
        System.out.println("Результат деления a на b с математическим округлением: " + roundResult);
        
        System.out.println("Остаток от деления b на c: " + (b % c));
        
        int minAB = Math.min(a, b);
        System.out.println("Наименьшее значение из a и b: " + minAB);
        
        int maxBC = Math.max(b, c);
        System.out.println("Наибольшее значение из b и c: " + maxBC);
        
        scanner.close();
    }
}

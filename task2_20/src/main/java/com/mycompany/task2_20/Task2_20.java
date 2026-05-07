/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.task2_20;
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author Admin
 */
public class Task2_20 {

    public static void main(String[] args) 
    {
        int[] array = new int[20];
        Random random = new Random();
        
        for (int i = 0; i < array.length; i++) 
        {
            array[i] = random.nextInt(15) + 1;
        }
        
        for (int i = 0; i < array.length; i++) 
        {
            System.out.print(array[i] + " ");
        }
        System.out.println(" : ");
        
        
        int[] count = new int[16]; // 1-15 (0-15)
        for (int i = 0; i < array.length; i++) 
        {
            count[array[i]]++;
        }
        
        for (int i = 1; i <= 15; i++) 
        {
            if (count[i] > 1) 
            {    
                System.out.println("Число '" + i + "' встречается " + count[i] + " " + "раз(а)");
            }
        }
    }
}

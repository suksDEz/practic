/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inputoutput;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class InputOutput {

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Как тебя зовут?");
        
        String name = scanner.nextLine();
        
        System.out.println("Привет, " + name + "!");
        
        scanner.close();
    }
}

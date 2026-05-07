package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main
{
    static void main()
    {
        SearchForSubstrings();
        Censorship();
        ConvertingWithoutData();
        ConvertingWithData();
    }

    static void  SearchForSubstrings()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку");
        String text = scanner.nextLine();

        System.out.println("Введите подстроку");
        String substring = scanner.nextLine();

        int count = 0;
        int index = text.indexOf(substring);

        while (index != -1)
        {
            count++;
            index = text.indexOf(substring, index + substring.length());
        }

        System.out.println("Подстрока '" + substring + "' встречается " + count + " раза");

        scanner.close();
    }

    static void Censorship()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку");
        String text = scanner.nextLine();

        String[] censoredWord = new String[] {"кака", "бяка"};

        String censored = text;

        for (int i = 0; i < censoredWord.length; i++)
        {
            censored = censored.replace(censoredWord[i], "вырезано цензурой");
        }

        System.out.println(censored);

        scanner.close();
    }

    static void ConvertingWithoutData()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите дату в формате 'дд.мм.гггг'");
        String date = scanner.nextLine();

        String[] parts = date.split("\\.");

        String day = parts[0];
        String month = parts[1];
        String year = parts[2];

        String newDate = year + "-" + month + "-" + day;

        System.out.println(newDate);

        scanner.close();
    }

    static void ConvertingWithData()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите дату в формате 'дд.мм.гггг'");
        String dateString = scanner.nextLine();

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");

        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;
        try
        {
            date = inputFormat.parse(dateString);
        }
        catch (ParseException e)
        {
            System.out.println("Ошибка: введена дата в неверном формате!");
        }

        String newDate = outputFormat.format(date);

        System.out.println(newDate);


        scanner.close();
    }
}

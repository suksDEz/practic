package org.example;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;

public class Main
{
    static void main()
    {
        Scanner scanner = new Scanner(System.in);

        try
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

            System.out.println("Введите дату в формате dd.MM.yyyy:");
            String dateString1 = scanner.nextLine();
            Date date1 = dateFormat.parse(dateString1);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date1);
            calendar.add(Calendar.DAY_OF_MONTH, 45);
            Date datePlus45Days = calendar.getTime();
            System.out.println("Дата после увеличения на 45 дней: " + dateFormat.format(datePlus45Days));

            calendar.setTime(date1);
            calendar.set(Calendar.DAY_OF_YEAR, 1);
            Date startOfYear = calendar.getTime();
            System.out.println("Дата после сдвига на начало года: " + dateFormat.format(startOfYear));

            calendar.setTime(date1);
            int workDaysAdded = 0;
            while (workDaysAdded < 10) {
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

                if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                    workDaysAdded++;
                }
            }
            Date datePlus10WorkDays = calendar.getTime();
            System.out.println("Дата после увеличения на 10 рабочих дней: " + dateFormat.format(datePlus10WorkDays));

            System.out.println("Введите вторую дату в формате dd.MM.yyyy:");
            String dateString2 = scanner.nextLine();
            Date date2 = dateFormat.parse(dateString2);

            Calendar startCal = Calendar.getInstance();
            Calendar endCal = Calendar.getInstance();

            if (date1.before(date2)) {
                startCal.setTime(date1);
                endCal.setTime(date2);
            } else {
                startCal.setTime(date2);
                endCal.setTime(date1);
            }

            startCal.add(Calendar.DAY_OF_MONTH, 1);

            int workDays = 0;

            while (startCal.before(endCal)) {
                int dayOfWeek = startCal.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                    workDays++;
                }
                startCal.add(Calendar.DAY_OF_MONTH, 1);
            }

            System.out.println("Количество рабочих дней между введенными датами: " + workDays);

        }
        catch (ParseException e)
        {
            System.out.println("Ошибка: введена дата в неверном формате!");
        }

        scanner.close();

    }
}

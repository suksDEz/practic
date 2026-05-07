package org.example;

import org.example.User.User;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    static void main()
    {
        //Task3_4();
        //Task3_5();
        //Task3_6();
    }

    static void Task3_4()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя первого пользователя");
        String name1 = scanner.nextLine();
        System.out.println("Введите возраст первого пользователя");
        Integer age1 = scanner.nextInt();
        scanner.nextLine();
        User user1 = new User(name1, age1);

        System.out.println("Введите имя второго пользователя");
        String name2 = scanner.nextLine();
        System.out.println("Введите возраст второго пользователя");
        Integer age2 = scanner.nextInt();
        User user2 = new User(name2, age2);

        if (user1.getAge() < user2.getAge()) {
            System.out.println(user1.toString());
        } else {
            System.out.println(user2.toString());
        }

        scanner.close();
    }

    static void Task3_5()
    {
        Scanner scanner = new Scanner(System.in);

        ArrayList<User> users = new ArrayList<>();

        for (int i = 1; i <= 5; i++)
        {
            System.out.println("Введите имя пользователя " + i);
            String name = scanner.nextLine();

            System.out.println("Введите возраст пользователя " + i);
            Integer age = scanner.nextInt();
            scanner.nextLine();

            User user = new User(name, age);
            users.add(user);
        }

        Collections.sort(users, new Comparator<User>()
        {
            public int compare(User u1, User u2) {
                return u1.getAge().compareTo(u2.getAge());
            }
        });

        for (User user : users)
        {
            System.out.println(user.toString());
        }

        scanner.close();
    }

    static void Task3_6()
    {
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, List<User>> usersByAge = new HashMap<>();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Введите имя пользователя " + i);
            String name = scanner.nextLine();

            System.out.println("Введите возраст пользователя " + i);
            Integer age = scanner.nextInt();
            scanner.nextLine();

            User user = new User(name, age);

            if (usersByAge.containsKey(age)) {
                List<User> userList = usersByAge.get(age);
                userList.add(user);
            } else {
                List<User> newUserList = new ArrayList<>();
                newUserList.add(user);
                usersByAge.put(age, newUserList);
            }
        }

        System.out.println("Введите требуемый возраст");
        Integer searchAge = scanner.nextInt();

        if (usersByAge.containsKey(searchAge))
        {
            List<User> users = usersByAge.get(searchAge);

            users.sort(Comparator.comparing(User::getName));

            for (User user : users)
            {
                System.out.println(user);
            }
        }
        else
        {
            System.out.println("Пользователь с возрастом '" + searchAge + "' не найден");
        }

        scanner.close();
    }
}

package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentWithClock implements Learner
{
    private Learner learner;

    public StudentWithClock(Learner learner) {
        this.learner = learner;
    }

    @Override
    public void learn() {
        learner.learn();

        Date now = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = formatter.format(now);

        System.out.println("Текущее время: " + formattedTime);
    }
}
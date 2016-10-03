package ru.sberbank.school.helloworld.tasks.lesson07;

/**
 * Created by Admin on 02.10.2016.
 */
public interface Calculator {

    @Cache
    double sum(double a, double b);

    double sum1(double a, double b);

}

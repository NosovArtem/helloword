package ru.sberbank.school.helloworld.tasks.lesson07;


public class Main {
    public static void main(String[] args) {

        Calculator calculator = new MyCalculator();
        Calculator myProxy = (Calculator) MyProxy.newInstance(calculator);

        myProxy.sum(3, 3);
        myProxy.sum(3, 2);
        myProxy.sum(3, 3);
        myProxy.sum(3, 2);

        //метод sum1 не отмечен аннотацией @Cache
        myProxy.sum1(3, 2);
        myProxy.sum1(3, 2);


    }
}
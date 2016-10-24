package ru.sberbank.school.helloworld.tasks.lesson10_Serialization;


import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Calculator calculator = new CalculatorImpl();
        Calculator myProxy = (Calculator) CacheProxyImpl.newInstance(calculator, CacheType.MEMORY, "");

        myProxy.sum(3, 3);
        myProxy.sum(3, 2);
        myProxy.sum(3, 3);
        myProxy.sum(3, 2);

    }

}

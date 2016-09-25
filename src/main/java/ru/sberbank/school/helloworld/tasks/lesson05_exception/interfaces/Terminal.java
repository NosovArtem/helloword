package ru.sberbank.school.helloworld.tasks.lesson05_exception.interfaces;

import ru.sberbank.school.helloworld.tasks.lesson05_exception.exceptions.NotEnoughMoneyException;


public interface Terminal {

    void putPin(int pin);

    void putMoney(int amountOfMoney);

    void getMoney(int amountOfMoney) throws NotEnoughMoneyException;

    void checkBalance();

}



package ru.sberbank.school.helloworld.tasks.lesson05_exception.interfaces;

import ru.sberbank.school.helloworld.tasks.lesson05_exception.exceptions.IncorrectAmountOfMoneyException;
import ru.sberbank.school.helloworld.tasks.lesson05_exception.exceptions.NotEnoughMoneyException;


public interface TerminalServer {

    int getMoney(int amountOfMoney) throws NotEnoughMoneyException, IncorrectAmountOfMoneyException;

    int putMoney(int amountOfMoney) throws IncorrectAmountOfMoneyException;

    long checkBalance();

}

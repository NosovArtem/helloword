package ru.sberbank.school.helloworld.tasks.lesson05_exception;

import ru.sberbank.school.helloworld.tasks.lesson05_exception.exceptions.IncorrectAmountOfMoneyException;
import ru.sberbank.school.helloworld.tasks.lesson05_exception.exceptions.NotEnoughMoneyException;
import ru.sberbank.school.helloworld.tasks.lesson05_exception.interfaces.TerminalServer;

/**
 *
 */
public class TerminalServerImpl implements TerminalServer {
    private long balance = 1000;

    @Override
    public int getMoney(int amountOfMoney) throws NotEnoughMoneyException, IncorrectAmountOfMoneyException {
        if (amountOfMoney % 100 != 0) {
            throw new IncorrectAmountOfMoneyException();
        }
        if (!(amountOfMoney <= balance)) {
            throw new NotEnoughMoneyException();
        }
        balance = balance - amountOfMoney;
        return amountOfMoney;
    }

    @Override
    public int putMoney(int amountOfMoney) throws IncorrectAmountOfMoneyException {
        if (amountOfMoney % 100 != 0) {
            throw new IncorrectAmountOfMoneyException();
        }
        balance = balance + amountOfMoney;
        return amountOfMoney;
    }

    @Override
    public long checkBalance() {
        return balance;
    }

    public long getBalance() {
        return balance;
    }
}

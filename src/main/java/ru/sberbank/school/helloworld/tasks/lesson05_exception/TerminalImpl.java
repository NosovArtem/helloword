package ru.sberbank.school.helloworld.tasks.lesson05_exception;

import ru.sberbank.school.helloworld.tasks.lesson05_exception.exceptions.*;
import ru.sberbank.school.helloworld.tasks.lesson05_exception.interfaces.PinValidator;
import ru.sberbank.school.helloworld.tasks.lesson05_exception.interfaces.Terminal;
import ru.sberbank.school.helloworld.tasks.lesson05_exception.interfaces.TerminalServer;

public class TerminalImpl implements Terminal {
    private final TerminalServer server = new TerminalServerImpl();
    private final PinValidator pinValidator = new PinValidatorImpl();
    private boolean access = false;


    @Override
    public void putPin(int pin) {
        try {
            pinValidator.verifyPin(pin);
            access = true;
            System.err.println("Successful. PIN-code is accepted.");
        } catch (IncorrectPinCodeException e) {
            System.err.println(HandleExceptions.handleException(e));
        } catch (AccountIsLockedException e) {
            System.err.println(HandleExceptions.handleException(e));
        }
    }

    @Override
    public void getMoney(int amountOfMoney) {
        try {
            checkTerminalAccess();
            System.err.println("The transaction is successful. You removed from bank account " +  server.getMoney(amountOfMoney) +  " $");
        } catch (NotEnoughMoneyException e) {
            System.err.println(HandleExceptions.handleException(e));
        } catch (IncorrectAmountOfMoneyException e) {
            System.err.println(HandleExceptions.handleException(e));
        } catch (PinCodeIsNotEnteredException e) {
            System.err.println(HandleExceptions.handleException(e));
        }
    }

    @Override
    public void putMoney(int amountOfMoney) {

        try {
            checkTerminalAccess();
            System.err.println("The transaction is successful. You deposited from bank account " +  server.putMoney(amountOfMoney) +  " $");
        } catch (IncorrectAmountOfMoneyException e) {
            System.err.println(HandleExceptions.handleException(e));
        } catch (PinCodeIsNotEnteredException e) {
            System.err.println(HandleExceptions.handleException(e));
        }
    }


    @Override
    public void checkBalance() {
        try {
            checkTerminalAccess();
            System.err.println("Successful. Your account balance of  " + server.checkBalance() +  " $");
        } catch (PinCodeIsNotEnteredException e) {
            System.err.println(HandleExceptions.handleException(e));
        }

    }

    private void checkTerminalAccess() throws PinCodeIsNotEnteredException {
        if (!access) {
            throw new PinCodeIsNotEnteredException();
        }
    }

}

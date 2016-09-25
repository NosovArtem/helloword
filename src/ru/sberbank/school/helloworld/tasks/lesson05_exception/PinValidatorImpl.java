package ru.sberbank.school.helloworld.tasks.lesson05_exception;

import ru.sberbank.school.helloworld.tasks.lesson05_exception.exceptions.AccountIsLockedException;
import ru.sberbank.school.helloworld.tasks.lesson05_exception.exceptions.IncorrectPinCodeException;
import ru.sberbank.school.helloworld.tasks.lesson05_exception.interfaces.PinValidator;

import java.util.Date;

public class PinValidatorImpl implements PinValidator {
    private int bankAccountPin = 1000;
    private int countPinError;
    private long dateError;


    @Override
    public void verifyPin(int clientPin) throws IncorrectPinCodeException, AccountIsLockedException {
        Date dateNow = new Date();
        if (dateError > dateNow.getTime()) {
            long l = dateError - dateNow.getTime();
            AccountIsLockedException e = new AccountIsLockedException(l);
            e.setMillisecond(l);
            throw e;
        }
        if (countPinError >= 3) {
            dateError = new Date().getTime() + 5000;
            countPinError = 0;
            throw new AccountIsLockedException();
        }
        if ((bankAccountPin != clientPin) && 1000 <= clientPin && clientPin <= 9999) {
            countPinError++;
            throw new IncorrectPinCodeException();
        }
    }
}

package ru.sberbank.school.helloworld.tasks.lesson05_exception.interfaces;

import ru.sberbank.school.helloworld.tasks.lesson05_exception.exceptions.AccountIsLockedException;
import ru.sberbank.school.helloworld.tasks.lesson05_exception.exceptions.IncorrectPinCodeException;

public interface PinValidator {

    void verifyPin(int clientPin) throws IncorrectPinCodeException, AccountIsLockedException;

    int getCountPinError();

    int getBankAccountPin();
}

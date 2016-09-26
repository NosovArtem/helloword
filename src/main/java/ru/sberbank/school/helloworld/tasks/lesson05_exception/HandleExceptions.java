package ru.sberbank.school.helloworld.tasks.lesson05_exception;

import ru.sberbank.school.helloworld.tasks.lesson05_exception.exceptions.*;


public class HandleExceptions {

    public static String handleException(Exception e) {
        String messege = "";
        if ((e instanceof AccountIsLockedException) && (0L != ((AccountIsLockedException) e).getMillisecond())) {
            messege = "AccountIsLockedException - The account was blocked. Up to unlock the remaining " + ((AccountIsLockedException) e).getMillisecond() + " milliseconds.";
        }
        if ((e instanceof AccountIsLockedException) && (0L == ((AccountIsLockedException) e).getMillisecond())) {
            messege = "AccountIsLockedException - The account was blocked.";
        }
        if (e instanceof IncorrectPinCodeException) {
            messege = "IncorrectPinCodeException - You have entered the incorrect PIN-Code.";
        }
        if (e instanceof IncorrectAmountOfMoneyException) {
            messege = "IncorrectAmountOfMoneyException - Amount must be a multiple of 100.";
        }
        if (e instanceof NotEnoughMoneyException) {
            messege = "NotEnoughMoneyException - It is not enough cash in the account.";
        }
        if (e instanceof PinCodeIsNotEnteredException) {
            messege = "PinCodeIsNotEnteredException - You have not entered the PIN-Code. Enter the PIN-code, and then repeat your attempt.";
        }
        return messege;
    }
}

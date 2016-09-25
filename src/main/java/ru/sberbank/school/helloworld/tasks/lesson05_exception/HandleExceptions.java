package ru.sberbank.school.helloworld.tasks.lesson05_exception;

import ru.sberbank.school.helloworld.tasks.lesson05_exception.exceptions.*;


public class HandleExceptions {

    public static String handleException(Exception e) {
        String messege = "";
        if ((e instanceof AccountIsLockedException) && (0L != ((AccountIsLockedException) e).getMillisecond())) {
            messege = "AccountIsLockedException - Учетная запись была заблокирована. До снятия блокировки осталось " + ((AccountIsLockedException) e).getMillisecond() + " миллисекунд.";
        }
        if ((e instanceof AccountIsLockedException) && (0L == ((AccountIsLockedException) e).getMillisecond())) {
            messege = "AccountIsLockedException - Учетная запись была заблокирована.";
        }
        if (e instanceof IncorrectPinCodeException) {
            messege = "IncorrectPinCodeException - Вы ввели неверный PIN-код.";
        }
        if (e instanceof IncorrectAmountOfMoneyException) {
            messege = "IncorrectAmountOfMoneyException - Вводимая сумма должна быть кратна 100.";
        }
        if (e instanceof NotEnoughMoneyException) {
            messege = "NotEnoughMoneyException - Недостаточно денежных средств на счете.";
        }
        if (e instanceof PinCodeIsNotEnteredException) {
            messege = "PinCodeIsNotEnteredException - Вы не ввели PIN-код. Введите PIN-код, после чего повторите вашу попытку.";
        }
        return messege;
    }
}

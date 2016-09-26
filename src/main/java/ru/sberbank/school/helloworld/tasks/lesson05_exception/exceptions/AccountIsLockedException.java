package ru.sberbank.school.helloworld.tasks.lesson05_exception.exceptions;

/**
 *Throws an exception when you try to enter a PIN code at the time of account lockout.
 *Account blocked if (countPinError >= 3) the number of attempts is greater than 3.
 */
public class AccountIsLockedException extends Exception {
    private long millisecond;

    public long getMillisecond() {
        return millisecond;
    }

    public AccountIsLockedException() {}

    public AccountIsLockedException(long millisecond) {
        this.millisecond = millisecond;
    }

}

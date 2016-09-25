package ru.sberbank.school.helloworld.tasks.lesson05_exception.exceptions;

/**
 *
 */
public class AccountIsLockedException extends Exception {
    private long millisecond;

    public long getMillisecond() {
        return millisecond;
    }

    public void setMillisecond(long millisecond) {
        this.millisecond = millisecond;
    }

    public AccountIsLockedException() {
    }

    public AccountIsLockedException(long millisecond) {
        this.millisecond = millisecond;
    }

}

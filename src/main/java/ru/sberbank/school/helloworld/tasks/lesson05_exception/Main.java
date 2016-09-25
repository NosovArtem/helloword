package ru.sberbank.school.helloworld.tasks.lesson05_exception;

/**
 *
 */
public class Main {
    public static void main(String[] args) {

        TerminalImpl terminal = new TerminalImpl();
        //Проверка блокировки после 3-х неудачных попыток ввода пинкода и блокировки терминала на 5 секунд.
       /* terminal.putPin(1111);
        terminal.putPin(1111);
        terminal.putPin(1111);
        terminal.putPin(1111);
        terminal.putPin(1111);
        terminal.putPin(1111);*/


        terminal.getMoney(1100);

        terminal.putPin(1001);
        terminal.putPin(1000);
        terminal.checkBalance();
        terminal.putMoney(1000);
        terminal.checkBalance();
        terminal.getMoney(101);
        terminal.getMoney(1000);
        terminal.checkBalance();
        terminal.getMoney(1100);
        terminal.checkBalance();



    }
}


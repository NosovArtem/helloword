package ru.sberbank.school.helloworld.tasks.lesson05_exception;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;


public class TerminalImplTest {
    public TerminalImpl terminal;

    @Before
    public void init() {
        terminal = new TerminalImpl();
        assertTrue("Inital state of varible 'access' expected false", false == terminal.isAccess());
        assertEquals(1000, terminal.getServer().checkBalance());
        assertEquals(1000, terminal.getPinValidator().getBankAccountPin());
    }

    @After
    public void tearDown() {
        terminal = null;
    }


    @Test
    public void putPin() throws InterruptedException {
        terminal.putPin(100);
        assertTrue("incorrect password has been entered", false == terminal.isAccess());
        assertEquals(1, terminal.getPinValidator().getCountPinError());
        terminal.putPin(10001);
        assertTrue("incorrect password has been entered", false == terminal.isAccess());
        assertEquals(2, terminal.getPinValidator().getCountPinError());
        terminal.putPin(1001);
        assertTrue("incorrect password has been entered", false == terminal.isAccess());
        assertEquals(3, terminal.getPinValidator().getCountPinError());
        terminal.putPin(1000);
        assertTrue("It was entered wrong password three times and the account is locked", false == terminal.isAccess());
        assertEquals(0, terminal.getPinValidator().getCountPinError());
        Thread.sleep(2000);
        terminal.putPin(1000);
        Thread.sleep(3000);
        terminal.putPin(1000);
        assertTrue("PIN-code is accepted. Expected true", true == terminal.isAccess());
    }

    @Test
    public void getMoney() {
        terminal.getMoney(100);
        assertEquals("Requested the correct amount", 1000, terminal.getServer().checkBalance());
        terminal.putPin(1000);
        assertTrue("PIN-code is accepted. Expected true", true == terminal.isAccess());
        terminal.getMoney(120);
        assertEquals("the amount is not a multiple of 100", 1000, terminal.getServer().checkBalance());
        terminal.getMoney(100);
        assertEquals("Requested the correct amount", 900, terminal.getServer().checkBalance());
        terminal.getMoney(1000);
        assertEquals("It is not enough cash in the account.", 900, terminal.getServer().checkBalance());

    }

    @Test
    public void putMoney() {
        terminal.putMoney(200);
        assertEquals("The transaction is successful. You deposited from bank account 200$.", 1000, terminal.getServer().checkBalance());
        terminal.putPin(1000);
        assertTrue("PIN-code is accepted. Expected true", true == terminal.isAccess());
        terminal.putMoney(222);
        assertEquals("the amount is not a multiple of 100", 1000, terminal.getServer().checkBalance());
        terminal.putMoney(200);
        assertEquals("The transaction is successful. You deposited from bank account 200$.", 1200, terminal.getServer().checkBalance());

    }

    @Test
    public void checkBalance() {
        terminal.checkBalance();
        terminal.putPin(1000);
        terminal.checkBalance();
    }


    public static void main(String[] args) throws Exception {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(TerminalImplTest.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }
}

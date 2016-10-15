package ru.sberbank.school.helloworld.tasks.lesson08.encrypted.plugin;

import ru.sberbank.school.helloworld.tasks.lesson08.encrypted.Plugin;

public class MyPlugin implements Plugin {
    @Override
    public void doUseful() {
        System.out.println("Plugin is decrypted");
    }
}
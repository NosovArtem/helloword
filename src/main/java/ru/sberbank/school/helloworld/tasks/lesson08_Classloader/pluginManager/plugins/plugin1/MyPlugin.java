package ru.sberbank.school.helloworld.tasks.lesson08_Classloader.pluginManager.plugins.plugin1;

import ru.sberbank.school.helloworld.tasks.lesson08_Classloader.pluginManager.Plugin;

public class MyPlugin implements Plugin {
    @Override
    public void doUseful() {
        System.out.println("plugin1");
    }
}
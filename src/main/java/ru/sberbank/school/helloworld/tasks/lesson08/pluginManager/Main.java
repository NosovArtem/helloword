package ru.sberbank.school.helloworld.tasks.lesson08.pluginManager;


import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws MalformedURLException, IllegalAccessException,
            InstantiationException, ClassNotFoundException {


        final String pluginRootDirectory = "C:\\SBTJavaSchool\\projectHelloWorld\\helloworld\\target\\classes\\";
        PluginLoader pluginManager = new PluginLoader(pluginRootDirectory);
        Plugin plugin1 = (Plugin) pluginManager.load("ru.sberbank.school.helloworld.tasks.lesson08.pluginManager.plugins.plugin1", "MyPlugin").newInstance();
        plugin1.doUseful();
        Plugin plugin2 = (Plugin) pluginManager.load("ru.sberbank.school.helloworld.tasks.lesson08.pluginManager.plugins.plugin2", "MyPlugin").newInstance();
        plugin2.doUseful();

    }
}
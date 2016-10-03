package ru.sberbank.school.helloworld.tasks.lesson07;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class MyProxy implements InvocationHandler {

    private Map<KeyForMap, Object> cache = new HashMap<>();
    private Object obj;

    public static Object newInstance(Object obj) {
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new MyProxy(obj));
    }

    private MyProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object value;
        if (!method.isAnnotationPresent(Cache.class)) {
            value = method.invoke(obj, args);
            System.err.println("Метод: " + "'" + method.getName() + "'" + " с аргументами : " + Arrays.asList(args) + " не кешировался, так как не помечен аннотацией @Cache. Ответ = " + value);
        } else {
            KeyForMap key = new KeyForMap(method.getName(), args);

            value = cache.get(key);
            if (value == null) {
                value = method.invoke(obj, args);
                cache.put(key, value);
                System.err.println("Метод: " + "'" + method.getName() + "'" + " с аргументами : " + Arrays.asList(args) + " не вызывался, ответ кеширован. Ответ = " + value);
            } else {
                System.err.println("Метод: " + "'" + method.getName() + "'" + " с аргументами : " + Arrays.asList(args) + " уже вызывался, ответ получен из кеша. Ответ = " + value);
            }
        }
        return value;
    }
}
package ru.sberbank.school.helloworld.tasks.lesson14_MultiplicationCache;

import ru.sberbank.school.helloworld.tasks.lesson07.Cache;
import ru.sberbank.school.helloworld.tasks.lesson07.KeyForMap;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class MultiplicationCacheProxy implements InvocationHandler {

    private Map<KeyForMap, Object> cache = new ConcurrentHashMap<>();
    private Map<KeyForMap, Lock> lockMap = new ConcurrentHashMap<>();
    private Object obj;

    public static Object newInstance(Object obj) {
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new MultiplicationCacheProxy(obj));
    }

    private MultiplicationCacheProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object value;
        System.out.println("Thread : " + "-" + Thread.currentThread().getName() + "-" + " Included in the method INVOKE");

        if (!method.isAnnotationPresent(Cache.class)) {
            System.out.println("This method is not cached");
            value = method.invoke(obj, args);
        }

        final KeyForMap key = new KeyForMap(method.getName(), args);

        Lock lock;
        synchronized (this) {
            if (lockMap.containsKey(key)) {
                lock = lockMap.get(key);
            } else {
                lock = new ReentrantLock();
                lockMap.put(key, lock);
            }
        }

        lock.lock();
        System.out.println("Thread : " + "-" + Thread.currentThread().getName() + "-" + " LOCK ");

        value = cache.get(key);
        if (value == null) {
            value = method.invoke(obj, args);
            cache.put(key, value);
            System.out.println("Thread : " + "-" + Thread.currentThread().getName() + "-" + " cached result ");
        } else {
            System.out.println("Thread : " + "-" + Thread.currentThread().getName() + "-" + " the result obtained from the cache ");

        }
        lock.unlock();
        System.out.println("Thread : " + "-" + Thread.currentThread().getName() + "-" + " UNLOCK ");

        return value;
    }

}
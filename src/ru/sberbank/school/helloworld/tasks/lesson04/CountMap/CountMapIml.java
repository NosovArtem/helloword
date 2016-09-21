package ru.sberbank.school.helloworld.tasks.lesson04.CountMap;

import java.util.HashMap;
import java.util.Map;

public class CountMapIml<T> implements CountMap<T> {

    private Map<T, Integer> map;

    CountMapIml() {
        map = new HashMap<>();
    }

    @Override
    public void add(T t) {
        if (map.containsKey(t)) {
            map.put(t, map.get(t) + 1);
        } else {
            map.put(t, 1);
        }
    }

    @Override
    public int getCount(T t) {
        int result = 0;
        if (map.containsKey(t)) {
            result = map.get(t);
        }
        return result;
    }

    @Override
    public int remove(T t) {
        int result = map.get(t);
        if (map.containsKey(t)) {
            map.remove(t);
        }
        return result;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        for (Map.Entry<T, Integer> entry : source.toMap().entrySet()) {
            if (map.containsKey(entry.getKey())) {
                map.put(entry.getKey(), map.get(entry.getKey()) + entry.getValue());
            } else {
                map.put(entry.getKey(), entry.getValue());
            }
        }

    }

    @Override
    public Map<T, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        for (Map.Entry<T, Integer> entry : map.entrySet()) {
            destination.put(entry.getKey(), entry.getValue());
        }
    }
}


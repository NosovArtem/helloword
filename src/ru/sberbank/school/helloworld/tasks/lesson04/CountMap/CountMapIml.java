package ru.sberbank.school.helloworld.tasks.lesson04.CountMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CountMapIml<T> implements CountMap<T> {

    private Map<T, Integer> map;

    CountMapIml() {
        map = new HashMap<>();
    }

    @Override
    public void add(T t) {
//        if (map.containsKey(t)) {
//            map.put(t, map.get(t) + 1);
//        } else {
//            map.put(t, 1);
//        }
        add(t, 1);
    }

    private void add(T t, int i) {
        map.merge(t, i, Integer::sum);
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
        return Optional.ofNullable(map.remove(t)).orElse(0);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<? extends T> source) {
//        for (Map.Entry<? extends T, Integer> entry : source.toMap().entrySet()) {
//            if (map.containsKey(entry.getKey())) {
//                map.put(entry.getKey(), map.get(entry.getKey()) + entry.getValue());
//            } else {
//                map.put(entry.getKey(), entry.getValue());
//            }
//        }
        if(source == null) {
            throw new NullPointerException();
        }
        source.toMap().forEach(this::add);
    }

    @Override
    public Map<T, Integer> toMap() {
        return new HashMap<>(map);
    }

    @Override
    public void toMap(Map<? super T, Integer> destination) {
//        for (Map.Entry<T, Integer> entry : map.entrySet()) {
//            destination.put(entry.getKey(), entry.getValue());
//        }
        destination.putAll(map);
    }
}


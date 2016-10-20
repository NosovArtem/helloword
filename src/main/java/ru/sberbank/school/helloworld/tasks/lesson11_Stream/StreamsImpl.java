package ru.sberbank.school.helloworld.tasks.lesson11_Stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;


public class StreamsImpl<T> {

    private List<T> c;

    private StreamsImpl(List<T> c) {
        this.c = c;
    }


    public static <T> StreamsImpl<T> of(List<T> c) {
        List<T> newC = new ArrayList(c);
        return new StreamsImpl<>(newC);

    }


    public StreamsImpl<T> filter(Predicate<? super T> predicate) {
        Iterator<T> iterator = c.iterator();
        while (iterator.hasNext()) {
            if (!predicate.test(iterator.next())) {
                iterator.remove();
            }
        }
        return this;
    }


    public <R> StreamsImpl<R> transform(Function<? super T, ? extends R> transform) {
        List<R> newTransformC = new ArrayList<>(c.size());
        c.forEach(c -> newTransformC.add(transform.apply(c)));

        return new StreamsImpl<>(newTransformC);
    }

    public <K, V> Map<K, V> toMap(Function<? super T, ? extends K> key, Function<? super T, ? extends V> value) {
        Map<K, V> map = new HashMap<>(c.size());
        c.forEach(e -> map.put(key.apply(e), value.apply(e)));
        return map;
    }


}





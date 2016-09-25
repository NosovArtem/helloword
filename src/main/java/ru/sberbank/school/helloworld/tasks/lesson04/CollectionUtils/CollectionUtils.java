package ru.sberbank.school.helloworld.tasks.lesson04.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {

    public static <E> void addAll(List<? extends E> source, List<? super E> destination) {
        destination.addAll(source);
    }

    public static <E> List<? extends E> newArrayList(E e) {
        List<E> list = new ArrayList<>();
        list.add(e);
        return list;
    }

    public static <E> int indexOf(List<? extends E> source, E e) {
        return source.indexOf(e);
    }

    public static <E> List limit(List<? extends E> source, int size) {
        return source.subList(0, size);
    }

    public static <E> void add(List<? super E> dest, E e) {
        dest.add(e);
    }

    public static <E> void removeAll(List<? super E> removeFrom, List<? extends E> c2) {
        removeFrom.removeAll(c2);
    }


    public static <E> boolean containsAll(List<? extends E> c1, List<? extends E> c2) {
        return c1.containsAll(c2);
    }

    public static <E> boolean containsAny(List<? extends E> c1, List<? extends E> c2) {
        for (E entry : c2) {
            if (c1.contains(entry)) {
                return true;
            }
        }
        return false;
    }

    public static <E extends Comparable> List range(List<E> list, E min, E max) {
        List<E> newList = new ArrayList<>();
        for (E entry : list) {
            if (entry.compareTo(min) > 0 && entry.compareTo(max) < 0) {
                newList.add(entry);
            }
        }
        return newList;
    }

    public static <E> List range(List<? extends E> list, E min, E max, Comparator<? super E> comparator) {
        List<E> newList = new ArrayList<>();
        for (E entry : list) {
            if (comparator.compare(min, entry) < 0 && comparator.compare(max, entry) > 0) {
                newList.add(entry);
            }
        }
        return newList;
    }
}

package ru.sberbank.school.helloworld.tasks.lesson04.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {

    public static <E> void addAll(List<? extends E> source, List<? super E> destination) {
        destination.addAll(source);
    }

    public static <E> List<E> newArrayList() {
        return new ArrayList<>();
    }

    public static <E> int indexOf(List<? extends E> source, E e) {
        return source.indexOf(e);
    }

    public static <E> List<E> limit(List<? extends E> source, int size) {
        return new ArrayList<>(source.subList(0, size));
    }

    public static <E> void add(List<E> dest, E e) {
        dest.add(e);
    }

    public static <E> void removeAll(List<?> removeFrom, List<?> c2) {
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

    public static <E extends Comparable<? super E>> List<E> range(List<? extends E> list, E min, E max) {
        List<E> newList = new ArrayList<>();
        for (E entry : list) {
            if (entry.compareTo(min) >= 0 && entry.compareTo(max) <= 0) {
                newList.add(entry);
            }
        }
        Collections.sort(newList);
        return newList;
    }

    public static <E> List<E> range(List<? extends E> list, E min, E max, Comparator<? super E> comparator) {
        List<E> newList = new ArrayList<>();
        for (E entry : list) {
            if (comparator.compare(min, entry) <= 0 && comparator.compare(max, entry) >= 0) {
                newList.add(entry);
            }
        }
        Collections.sort(newList, comparator);
        return newList;
    }
}

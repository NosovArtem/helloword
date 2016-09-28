package ru.sberbank.school.helloworld.tasks.lesson04.CollectionUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> integerList2 = new ArrayList<>(Arrays.asList(6, 7, 8, 9, 5));

//        System.out.println("List integerList1 : " + integerList1);
//        System.out.println("List integerList2 : " + integerList2);
//
//        System.out.println("contayntsAll... " + CollectionUtils.containsAll(integerList1, integerList2) );
//        System.out.println("contayntsAny... " + CollectionUtils.containsAny(integerList1, integerList2) );
//
//        System.out.println("range " + CollectionUtils.range(integerList1, 0, 5));
//        Comparator<Integer> comparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        };
//        System.out.println("rangeComporator " + CollectionUtils.range(integerList1, 0, 5, comparator ));
//
//        System.out.println(CollectionUtils.newArrayList());
//        System.out.println(CollectionUtils.<Number>indexOf(integerList1, 4));
//
//        CollectionUtils.addAll(integerList1, integerList2);
//
//        System.out.println("integerList2 : " + integerList2);
//        System.out.println("integerList1 : " + integerList1);
//        CollectionUtils.removeAll(integerList2, integerList1);
//        System.out.println("integerList2 : " + integerList2);
//        CollectionUtils.add(integerList2, 5);
//
//        System.out.println(integerList2);
//        System.out.println(CollectionUtils.limit(integerList1, 3));

//        List<Number> yyy = CollectionUtils.limit(integerList1, 3);
//        yyy.add(1.);
//        integerList1.get(3).compareTo(1);
//
//        List<Double> xxx = CollectionUtils.newArrayList();
//        xxx.add(1.);

        List<B> b = null;

        List<A> r = CollectionUtils.range(b, new B(), new B(), new Comparator<A>() {
            @Override
            public int compare(A o1, A o2) {
                return 0;
            }
        });
    }
}


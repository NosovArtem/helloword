package ru.sberbank.school.helloworld.tasks.lesson04.CountMap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.DoubleAccumulator;

public class Main {
    public static void main(String[] args) {

        CountMap<Number> countMap = new CountMapIml<>();
        CountMap<Integer> countMapInt = new CountMapIml<>();
        countMap.addAll(countMapInt);

        Map<Number, Integer> dest = new HashMap<>();
        countMapInt.toMap(dest);

        countMap.add(1.1);

//        CountMap<String> countMap = new CountMapIml<>();
//        CountMap<String> countMap2 = new CountMapIml<>();
//        CountMap<String> countMap3 = new CountMapIml<>();
//        countMap.add(null);
//        countMap.add("Ira");
//        countMap.add("Artem");
//        countMap.add("Artem");
//        countMap.add("Serg");
//
//        countMap2.add("Serg");
//        countMap2.add("Serg");
//        System.out.println("countMap : " + countMap.getCount("Artem") + " записи " + "Artem");
//        System.out.println("countMap : " + countMap.getCount("Serg") + " записи " + "Serg");
//        System.out.println("countMap : " + countMap.getCount(null) + " записи " + "null");
//        System.out.println("countMap : " + countMap.getCount("Ira") + " записи " + "Ira");
//        System.out.println("size countMap = " + countMap.size());
//        System.out.println(" ");
//        System.out.println("delete Ira " + countMap.remove("Ira"));
//        System.out.println("countMap Ira : " + countMap.getCount("Ira"));
//        System.out.println("size countMap = " + countMap.size());
//        System.out.println(" ");
//
//        System.out.println("countMap Serg : " + countMap.getCount("Serg"));
//        countMap.addAll(countMap2);
//        System.out.println("countMap Serg : " + countMap.getCount("Serg"));
//        System.out.println(" ");
//
//        System.out.println("map from countMap : " + countMap.toMap());
//        System.out.println(" ");
//
//        System.out.println("countMap size : " + countMap.size() + " countMap3 size : " + countMap3.size());
//        countMap.toMap(countMap3.toMap());
//        System.out.println("countMap size : " + countMap.size() + " countMap3 size : " + countMap3.size());
    }
}
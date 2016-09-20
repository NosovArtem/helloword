package ru.sberbank.school.helloworld.tasks.lesson04;

public class Main {
    public static void main(String[] args) {
        CountMap<String> countMap = new CountMapIml<>();
        CountMap<String> countMap2 = new CountMapIml<>();

        countMap.add(null);
        countMap.add("Ira");
        countMap.add("Artem");
        countMap.add("Artem");
        countMap.add("Serg");

        countMap2.add("Serg");
        countMap2.add("Serg");

        System.out.println("В countMap содержится " + countMap.getCount("Artem") + " записи " + "Artem");
        System.out.println("В countMap содержится " + countMap.getCount("Serg") + " записи " + "Serg");
        System.out.println("В countMap содержится " + countMap.getCount(null) + " записи " + "null");
        System.out.println("В countMap содержится " + countMap.getCount("Ira") + " записи " + "Ira");
        System.out.println("Размер countMap " + countMap.size());
        System.out.println(" ");
        System.out.println("Удалим запись Ira " + countMap.remove("Ira"));
        System.out.println("Сейчас кол-во записей Ira " + countMap.getCount("Ira"));
        System.out.println("Сейчас кол-во записей Ira " + countMap.getCount("Ira"));
        System.out.println("Размер countMap " + countMap.size());
        System.out.println(" ");

        System.out.println("Далее.... ");
        System.out.println("До метод addAll Serg : " + countMap.getCount("Serg"));
        countMap.addAll(countMap2);
        System.out.println("После метод addAll Serg : " + countMap.getCount("Serg"));
        System.out.println(" ");

        System.out.println(countMap);
        System.out.println("Достанем и распечатае map из countMap : " + countMap.toMap());
        System.out.println(" ");

        System.out.println("to Map dest countMap size : " + countMap.size() + " countMap2 size : " + countMap2.size());
        countMap.toMap(countMap2.toMap());
        System.out.println("countMap source size : " + countMap.size() + " countMap2 destination size : " + countMap2.size());
    }
}
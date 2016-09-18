package ru.sberbank.school.helloworld.tasks.lesson02;

public class Main {
    public static void main(String[] args) {
        Person andrey1 = new Person(true, "Andrey1");
        Person masha1 = new Person(false, "Masha1");
        Person andrey2 = new Person(true, "Andrey2");
        Person masha2 = new Person(false, "Masha2");

        masha1.marry(andrey2);
        andrey2.marry(masha2);
        andrey1.marry(masha2);
        andrey1.marry(null);

    }
}

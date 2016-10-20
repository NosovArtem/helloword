package ru.sberbank.school.helloworld.tasks.lesson11_Stream;

import ru.sberbank.school.helloworld.tasks.lesson02.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        List<Person> someCollection = Arrays.asList(new Person(true, "Artem", 25),
                new Person(true, "Alexander", 23),
                new Person(false, "Nika", 15),
                new Person(false, "Masha", 19));


        Map m = StreamsImpl.of(someCollection)
                .filter(p -> p.getAge() > 20)
                .transform(p -> new Person(p.isMan(), p.getName(), p.getAge() + 30))
                .toMap(Person::getName, Person::getAge);

        System.out.println(m);


    }
}

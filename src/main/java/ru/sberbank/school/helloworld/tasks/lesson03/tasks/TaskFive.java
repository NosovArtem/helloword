package ru.sberbank.school.helloworld.tasks.lesson03.tasks;

import ru.sberbank.school.helloworld.tasks.lesson03.MyIterator;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TaskFive {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>(Arrays.asList("sup1", "sup2", "sup3"));

        MyIterator myIterator = new MyIterator(list);
        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }
    }
}
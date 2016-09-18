package ru.sberbank.school.helloworld.tasks.lesson03.tasks;

import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;


public class TaskTwo {

    public static void main(String[] args) throws IOException {

        Set<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int length = o1.length() - o2.length();
                if (length != 0) {
                    return length;
                }
                return o1.compareToIgnoreCase(o2);
            }
        });

        TaskOne.addWordsToSet(treeSet);

        for (Object aTreeSet : treeSet) {
            System.out.println(aTreeSet);
        }
    }
}

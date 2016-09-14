package ru.sberbank.school.helloworld.tasks.Lesson02;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Admin on 12.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        Person andrey1 = new Person(true, "Andrey1");
        Person andrey3 = new Person(true, "Andrey1");
        Person masha1 = new Person(false, "Masha1");
        Person andrey2 = new Person(true, "Andrey2");
        Person masha2 = new Person(false, "Masha2");


        andrey3.marry(masha1);

        masha1.marry(andrey2);

        andrey2.marry(masha2);

        andrey1.marry(masha2);

        andrey1.equals(andrey3);

        //TODO: adequate checks are needed.
        //TODO: like this:
        if(andrey1.marry(null)){
            System.out.println("ERROR: manIgor.marry(null)");
        }

    }
}

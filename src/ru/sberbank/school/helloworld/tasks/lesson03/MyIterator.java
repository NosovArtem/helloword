package ru.sberbank.school.helloworld.tasks.lesson03;

import java.util.Iterator;
import java.util.List;

public class MyIterator implements Iterator {
    private List list;
    private Integer index;


    public MyIterator(List list) {
        this.list = list;
        index = list.size();
    }

    @Override
    public boolean hasNext() {
        if (index > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        index = index - 1;
        return list.get(index);
    }

    @Override
    public void remove() {
        list.remove(index);
    }
}

package ru.sberbank.school.helloworld.tasks.lesson07;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class KeyForMap {

    String methodName;

    List<Object> args;

    public KeyForMap(String methodName, Object[] args) {
        this.methodName = methodName;
        this.args = Arrays.asList(args);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KeyForMap)) {
            return false;
        }
        KeyForMap that = (KeyForMap) o;
        return Objects.equals(methodName, that.methodName) &&
                Objects.equals(args, that.args);
    }

    @Override
    public int hashCode() {

        return Objects.hash(methodName, args);
    }
}



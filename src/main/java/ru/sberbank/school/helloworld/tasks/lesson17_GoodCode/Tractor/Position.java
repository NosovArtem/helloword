package ru.sberbank.school.helloworld.tasks.lesson17_GoodCode.Tractor;

public class Position {
    private int x;
    private int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void incrementX() {
        x++;
    }

    void incrementY() {
        y++;
    }

    void decrementX() {
        x--;
    }

    void decrementY() {
        y--;
    }

    boolean isPositionInsideField(Field field) {
        return x > field.getX() || y > field.getY();
    }
}
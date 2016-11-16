package ru.sberbank.school.helloworld.tasks.lesson17_GoodCode.Tractor;

public interface Tractor {

    void move(String command) throws TractorInDitchException;

    void moveForwards() throws TractorInDitchException;

    void turnClockwise();

    int getPositionX();

    int getPositionY();

    void xIncrement();

    void yIncrement();

    void xDecrement();

    void yDecrement();

    void setOrientation(Orientation orientation);

    Orientation getOrientation();


}
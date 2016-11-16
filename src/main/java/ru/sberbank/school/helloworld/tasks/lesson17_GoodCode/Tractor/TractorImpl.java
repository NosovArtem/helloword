package ru.sberbank.school.helloworld.tasks.lesson17_GoodCode.Tractor;

public class TractorImpl implements Tractor {

    Position position;
    Field field;
    Orientation orientation;


    TractorImpl(Position position, Field field, Orientation orientation) {
        this.position = position;
        this.field = field;
        this.orientation = orientation;
    }

    public void move(String command) throws TractorInDitchException {
        Commands.valueOf(command).command(this);
    }

    public void moveForwards() throws TractorInDitchException {
        orientation.moveForwards(this);
        checkField();
    }

    public void turnClockwise() {
        orientation.turnClockwise(this);
    }

    private void checkField() throws TractorInDitchException {
        if (!position.isPositionInsideField(field)) {
            throw new TractorInDitchException("Tractor left field border." +
                    " Position [" + position.getX() + "," + position.getY() + "]" +
                    " Field [" + field.getX() + "," + field.getY() + "]");
        }
    }

    public int getPositionX() {
        return position.getX();
    }

    public int getPositionY() {
        return position.getY();
    }

    public void xIncrement() {
        position.incrementX();
    }

    public void yIncrement() {
        position.incrementY();
    }

    public void xDecrement() {
        position.decrementX();
    }

    public void yDecrement() {
        position.decrementY();
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

}